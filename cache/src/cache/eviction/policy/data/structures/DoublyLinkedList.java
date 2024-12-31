package cache.eviction.policy.data.structures;

public class DoublyLinkedList<KEY> {
    /*
     * I will add remove nodes between these 2 dummy nodes
     * head and tail to efficiently handle edge cases
     */
    private Node<KEY> head;
    private Node<KEY> tail;

    public DoublyLinkedList() {
        tail = new Node<KEY>(null, null, null);
        head = new Node<KEY>(null, tail, null);
        tail.setLeft(head);
    }

    public void addNodeToStart(Node<KEY> node) {
        Node<KEY> rNode = head.getRight();
        head.setRight(node);
        node.setRight(rNode);
        node.setLeft(head);
        rNode.setLeft(head);

    }

    public Node<KEY> removeNode(Node<KEY> node) {
        Node<KEY> rNode = node.getRight();
        Node<KEY> lNode = node.getLeft();
        lNode.setRight(rNode);
        rNode.setLeft(lNode);
        return node;
    }

    public Node<KEY> removeLastNode() {
        Node<KEY> lastNode = tail.getLeft();
        Node<KEY> secondLastNode = lastNode.getLeft();
        secondLastNode.setRight(tail);
        tail.setLeft(secondLastNode);
        return lastNode;
    }
}
