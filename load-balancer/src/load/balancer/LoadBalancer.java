package load.balancer;

import java.util.List;
import java.util.TreeMap;

import load.balancer.hash.strategy.HashingStrategy;

public class LoadBalancer {
    private volatile TreeMap<Long, Node> circle;
    private final HashingStrategy hashingStrategy;
    private final List<Node> nodes;

    public LoadBalancer(HashingStrategy hashingStrategy, List<Node> nodes) {
        this.hashingStrategy = hashingStrategy;
        this.nodes = nodes;
        constructNodeHashingCircle();
    }

    private void constructNodeHashingCircle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constructNodeHashingCircle'");
    }

}
