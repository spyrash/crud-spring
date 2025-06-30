package CRUD.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {

    @Bean  // the return value of th method get injected into the spring container using dependency injection
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager manager = new ConcurrentMapCacheManager();
        manager.setAllowNullValues(false);
        manager.setCacheNames(Arrays.asList("productCache"));
        return manager;
    }

   // @CacheEvict(value = "productCache", allEntries = true)
   // @Scheduled(fixedRate = 7000, initialDelay = 0) // every 7 seconds
   // public void evictProductCache() {
   //     System.out.println("evicting product cache...");
   //     System.out.println("done!");
   // }
}
