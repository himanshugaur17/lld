package cache.eviction.policy;

import java.util.Optional;

public interface EvictionPolicy<KEY> {
    void keyAccessed(KEY key);

    Optional<KEY> evict();
}
