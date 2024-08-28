import java.util.ArrayList;
import java.util.List;

public class N_ary_tree_postorder_traversal {
    List<Integer> output;
    public List<Integer> postorder(Node root) {
        output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        traversal(root);
        return output;
    }

    private void traversal(Node node) {
        if (!node.children.isEmpty()) {
            for (Node child : node.children) {
                traversal(child);
            }
        }
        output.add(node.val);
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};