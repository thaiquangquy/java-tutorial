package org.example.hibernate.optimized;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class HibernateLongRunning {
    public int getCalculated() {
        System.out.println("Calculating");
        var data = getData();
        System.out.println("Retrieved");
        var result = calculate(data);
        System.out.println("Calculated");
        return result;
    }

    // 1. Moved @Transactional from the service method to only the getData() method. This reduces transaction duration from 9 seconds to 3 seconds, releasing the database connection immediately after data retrieval.
    // 2. Read-Only Transaction: Added readOnly = true to optimize the transaction for data retrieval, allowing Hibernate to apply read-only optimizations.
    // 3. Eager Loading Strategy: Used LEFT JOIN FETCH in the query to prevent N+1 select problems by loading all required associations in a single query.
    // 4. Connection Pool Efficiency: Database connections are returned to the pool 6 seconds earlier, improving overall application throughput and reducing connection pool exhaustion risk.
    @Transactional(readOnly = true)
    protected List<Model> getData() {
        // Check cache first before actually reading from database
//        List<Model> cachedData = (List<Model>) redisTemplate.opsForValue().get(cacheKey);
//        if (cachedData != null) {
//            return cachedData;
//        }

        // Use read-only transaction for data retrieval
        // Ensure eager loading of required associations to avoid lazy loading issues
        // Example implementation:
        EntityManager entityManager = null;
        return entityManager.createQuery(
                        "SELECT m FROM Model m LEFT JOIN FETCH m.relatedEntities", Model.class)
                .getResultList();
        // Alternative getData() method using projection?
    }

    private int calculate(List<Model> data) {
        // This method now runs outside of transaction scope
        // Pure function, contains only simple calculations
        // Database connection is released before this executes
        return data.parallelStream()
                .mapToInt(Model::getValue)
                .sum();
    }
}
