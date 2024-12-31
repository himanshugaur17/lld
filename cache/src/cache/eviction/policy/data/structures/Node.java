package cache.eviction.policy.data.structures;

public class Node<KEY> {
    private Node left;
    private Node right;
    private KEY key;

    public Node(Node left, Node right, KEY key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

    public Node(KEY key) {
        this(null, null, key);
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public KEY getKey() {
        return key;
    }

    public void setKey(KEY key) {
        this.key = key;
    }

}
