package load.balancer;


public class Node {
    int vNodes;
    String id;
    String hostName;
    String port;

    public Node(int vNodes, String id, String hostName, String port) {
        this.vNodes = vNodes;
        this.id = id;
        this.hostName = hostName;
        this.port = port;
    }

    public String getNodeKey() {
        return hostName + port + id;
    }

}
