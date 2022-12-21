package com.example.githubactionstut.shared.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
Um Caching einzusachelten, brauche ich eine Bean mit @Configuration Annotation,
die das Caching managed. Dieses muss CacheCustomizerManager implementieren.
Dieses muss die Methode customize implementieren. Da schmeisst du Bezeichner rein,
die für Werte stehen, die gecached werden sollen,
anstatt immer wieder aus der DB rausgekramt zu werden.
 */

@Component
public class CacheConfig implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    @Override
    public void customize(ConcurrentMapCacheManager concurrentMapCacheManager) {
        concurrentMapCacheManager.setCacheNames(Arrays.asList("seasons"));
    }
}
