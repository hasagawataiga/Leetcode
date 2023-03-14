package Binary_tree.Conclusion;

import java.util.LinkedList;
import java.util.Queue;

// Using Breadth-First-Search algorithm
//  and create a preNode variable for connect node.next
public class Populating_next_right_pointers_in_each_node {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        root.next = null;
        Node head = root;
        Queue<Node> queue = new LinkedList<>();
        if (root.left == null){
            return head;
        } else {
            queue.add(root.left);
            queue.add(root.right);
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            Node preNode = queue.poll();
            if (preNode.left != null){
                queue.add(preNode.left);
                queue.add(preNode.right);
            }
            for (int i = 1; i < size; i++){
                Node node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
                preNode.next = node;
                preNode = preNode.next;
            }
            preNode.next = null;
        }
        return head;
    }
}
