package Daily_questions;

import java.util.LinkedList;
import java.util.Queue;

import interview_questions.trees.TreeNode;

// Using Breadth-First-Search algorithm
// addition condition: whenever reaching a null node, all nodes later must be null also.
public class Check_completeness_of_a_binary {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return true;
        }
        queue.add(root);
        boolean isNullNodeAppeared = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    if (!isNullNodeAppeared){
                        queue.add(node.left);
                    } else {
                        return false;
                    }
                } else {
                    isNullNodeAppeared = true;
                }
                if (node.right != null){
                    if (!isNullNodeAppeared){
                        queue.add(node.right);
                    } else {
                        return false;
                    }
                } else {
                    isNullNodeAppeared = true;
                }
            }
        }
        return true;
    }
}
