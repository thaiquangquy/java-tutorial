//package org.example.hibernate.optimization.finalSolution;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.time.Duration;
//import java.util.concurrent.ThreadPoolExecutor;
//
//@Configuration
//@EnableAsync
//@EnableCaching
//public class PerformanceConfig {
//
//    @Bean(name = "taskExecutor")
//    public TaskExecutor taskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(4);
//        executor.setMaxPoolSize(8);
//        executor.setQueueCapacity(25);
//        executor.setThreadNamePrefix("OptimizedTask-");
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(60);
//        executor.initialize();
//        return executor;
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(1))
//                .disableCachingNullValues()
//                .serializeKeysWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
//
//        return RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(config)
//                .transactionAware()
//                .build();
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
//        template.afterPropertiesSet();
//        return template;
//    }
//}
