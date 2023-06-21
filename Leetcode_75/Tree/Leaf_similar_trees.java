package Leetcode_75.Tree;

import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

public class Leaf_similar_trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traversal(root1, list1);
        traversal(root2, list2);
        return list1.equals(list2);
    }
    private void traversal(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            list.add(node.val);
        }
        if (node.left != null){
            traversal(node.left, list);
        }
        if (node.right != null){
            traversal(node.right, list);
        }
    }
}
