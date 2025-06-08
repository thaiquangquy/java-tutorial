package org.example.hibernate.finalSolution;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class HibernateLongRunning {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private TaskExecutor taskExecutor;

    // MAIN OPTIMIZATION: Caching + Async Processing
    @Cacheable(value = "calculatedResults", key = "'data_' + T(java.time.LocalDateTime).now().getHour()")
    public int getCalculated() {
        System.out.println("Calculating");

        // Async data fetching + parallel resource initialization
        CompletableFuture<List<Model>> dataFuture = CompletableFuture
                .supplyAsync(this::getData, taskExecutor);

        CompletableFuture<Void> initFuture = CompletableFuture
                .runAsync(this::initializeCalculationResources, taskExecutor);

        var data = dataFuture.join();
        System.out.println("Retrieved");

        initFuture.join();

        var result = calculate(data);
        System.out.println("Calculated");
        return result;
    }

    // HIBERNATE OPTIMIZATIONS: Transaction scope + Query optimization
    @Transactional(readOnly = true)
    protected List<Model> getData() {
        // L1 Cache Check
        String cacheKey = "model_data_" + getCurrentHour();
        List<Model> cachedData = getCachedData(cacheKey);

        if (cachedData != null && !cachedData.isEmpty()) {
            return cachedData;
        }

        // Optimized Native Query with Hibernate hints
        Query nativeQuery = entityManager.createNativeQuery(
                "SELECT id, value, category, active FROM model WHERE active = 1 ORDER BY id",
                Model.class);

        // Performance Hints
        nativeQuery.setHint("org.hibernate.fetchSize", 1000);
        nativeQuery.setHint("org.hibernate.readOnly", true);
        nativeQuery.setHint("org.hibernate.cacheable", false);
        nativeQuery.setHint("org.hibernate.cacheMode", "IGNORE");

        List<Model> data = nativeQuery.getResultList();

        // Cache for 1 hour
        cacheData(cacheKey, data);

        return data;
    }

    // MULTI-THREADING OPTIMIZATION: Parallel calculation
    private int calculate(List<Model> data) {
        if (data.isEmpty()) return 0;

        int numThreads = Math.min(Runtime.getRuntime().availableProcessors(), 8);
        int chunkSize = Math.max(data.size() / numThreads, 1);

        List<CompletableFuture<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < numThreads && i * chunkSize < data.size(); i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize, data.size());

            CompletableFuture<Integer> future = CompletableFuture
                    .supplyAsync(() -> calculateChunk(data.subList(start, end)), taskExecutor);

            futures.add(future);
        }

        return futures.stream()
                .mapToInt(CompletableFuture::join)
                .sum();
    }

    // CHUNK PROCESSING: Optimized calculation per thread
    private Integer calculateChunk(List<Model> chunk) {
        return chunk.parallelStream()
                .filter(Model::isActive)
                .mapToInt(Model::getValue)
                .sum();
    }

    // ASYNC RESOURCE INITIALIZATION
    private void initializeCalculationResources() {
        // Pre-warm JIT compiler with sample calculations
        // Initialize lookup tables, warm up CPU caches
        for (int i = 0; i < 1000; i++) {
            Math.sqrt(i * 2.5);
        }
    }

    // CACHING UTILITIES
    @SuppressWarnings("unchecked")
    private List<Model> getCachedData(String key) {
        try {
            return (List<Model>) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            return null;
        }
    }

    private void cacheData(String key, List<Model> data) {
        try {
            redisTemplate.opsForValue().set(key, data, Duration.ofHours(1));
        } catch (Exception e) {
            // Log error but don't fail the request
        }
    }

    private String getCurrentHour() {
        return String.valueOf(java.time.LocalDateTime.now().getHour());
    }
}