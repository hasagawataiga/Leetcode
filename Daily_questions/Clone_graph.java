import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Clone_graph {
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        Node res = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, res);
        queue.add(node);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            for (Node neighbor: tempNode.neighbors){
                if (!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(tempNode).neighbors.add(map.get(neighbor));
            }
        }
        return res;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
