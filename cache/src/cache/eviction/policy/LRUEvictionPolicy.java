package cache.eviction.policy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import cache.eviction.policy.data.structures.DoublyLinkedList;
import cache.eviction.policy.data.structures.Node;

public class LRUEvictionPolicy<KEY> implements EvictionPolicy<KEY> {
    private final DoublyLinkedList<KEY> dll;
    private final Map<KEY, Node<KEY>> keyToNodeMap;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.keyToNodeMap = new HashMap<>();

    }

    @Override
    public void keyAccessed(KEY key) {
        this.keyToNodeMap.computeIfAbsent(
                key, (k) -> new Node<>(k));
        Node<KEY> node = this.keyToNodeMap.get(key);
        if (node.getLeft() != null && node.getRight() != null)
            this.dll.removeNode(node);
        this.dll.addNodeToStart(node);
    }

    @Override
    public Optional<KEY> evict() {
        Node<KEY> lastNode = dll.removeLastNode();
        keyToNodeMap.remove(lastNode);
        return Optional.ofNullable(lastNode.getKey());
    }

}
