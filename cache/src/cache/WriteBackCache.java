package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import cache.eviction.policy.EvictionPolicy;
import data.storage.IDataStorage;

/*
 * Notes:
 * The writeback cache will update the cache and schedules the updation
 * of key in the database to happen asynchronously.
 */
public class WriteBackCache<KEY, VALUE> implements Cache<KEY, VALUE> {
    private IDataStorage<KEY, VALUE> backingDataStorage;
    private final ExecutorService executorService;
    private final Map<KEY, VALUE> cache;
    private EvictionPolicy<KEY> evictionPolicy;
    private int capacity;

    public WriteBackCache(IDataStorage<KEY, VALUE> dataStorage, ExecutorService executorService, int capacity,
            EvictionPolicy<KEY> evictionPolicy) {
        this.backingDataStorage = dataStorage;
        this.executorService = executorService;
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public VALUE get(KEY key) {
        if (!cache.containsKey(key)) {
            VALUE value = backingDataStorage.get(key);
            cache.put(key, value);
        }
        return cache.get(key);
    }

    @Override
    public void set(KEY key, VALUE value) {
        if (cache.size() == capacity && !cache.containsKey(key)) {
            KEY evictedKey = this.evictionPolicy.evict().get();
            System.out.println(String.format("log key eviction: %s", evictedKey));
        }
        cache.put(key, value);
        /*
         * Write back into database asynchronously
         */
        CompletableFuture.runAsync(() -> this.backingDataStorage.put(key, value), executorService);
    }

}
