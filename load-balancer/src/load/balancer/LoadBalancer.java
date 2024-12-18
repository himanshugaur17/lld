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
        for (Node node : nodes) {
            for (int i = 0; i < node.vNodes; i++) {
                circle.put(hashRecursively(node.getNodeKey(), node.vNodes), node);
            }
        }
    }

    /*
     * We are using recursive hash strategy (or we could have used different hash
     * function / vNode)
     * so that for each vNode we get a unique representation
     * on consistent hashring.
     */
    private Long hashRecursively(String key, int times) {
        Long hashedValue = hashingStrategy.hash(key);
        times--;
        while (times-- > 0) {
            hashedValue = hashingStrategy.hash(hashedValue.toString());
        }
        return hashedValue;
    }

    /*
     * Overall time complexity becomes
     * O(log(N*K))
     */
    private Node getNodeForKey(long hash) {
        Node node = circle.get(hash);
        if (node != null)
            return node;
        /*
         * ceilingEntry itself takes wraps around to the first element
         * incase there is no entry having key greater than hash
         */
        return circle.ceilingEntry(hash).getValue();
    }

    public Node serveRequest(Request req) {
        return getNodeForKey(req.hashCode());
    }
}
