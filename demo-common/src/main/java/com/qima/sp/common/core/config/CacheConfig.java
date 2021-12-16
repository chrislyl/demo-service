package com.qima.sp.common.core.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author Yulong
 * @date 2021/12/9 18:17
 */
@Configuration
public class CacheConfig {

    @Bean("caffeineCacheManager")
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterAccess(60, TimeUnit.SECONDS)
                .initialCapacity(100)
                .maximumSize(1000));
        return cacheManager;
    }
}
