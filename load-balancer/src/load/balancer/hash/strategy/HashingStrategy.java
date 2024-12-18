package load.balancer.hash.strategy;

public interface HashingStrategy {
    long hash(final String k);
}
