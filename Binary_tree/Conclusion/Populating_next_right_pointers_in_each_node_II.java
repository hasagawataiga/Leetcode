package Binary_tree.Conclusion;

import java.util.LinkedList;
import java.util.Queue;

// Using Breadth-First-Search algorithm
//  and create a preNode variable for connect node.next
public class Populating_next_right_pointers_in_each_node_II {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        root.next = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node preNode = queue.poll();
            if (preNode.left != null){
                queue.add(preNode.left);
            }
            if (preNode.right != null){
                queue.add(preNode.right);
            }
            for (int i = 1; i < size; i++){
                Node node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
                preNode.next = node;
                preNode = node;
            }
            preNode.next = null;
        }
        return root;
    }
}
