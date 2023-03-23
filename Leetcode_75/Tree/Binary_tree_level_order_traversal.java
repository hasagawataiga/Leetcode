package Leetcode_75.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import interview_questions.trees.TreeNode;

// Using BFS algorithm 
public class Binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null){
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null){
                    queue.add(tempNode.right);
                }
                temp.add(tempNode.val);
            }
            res.add(temp);
        }
        return res;
    }
}
