package Leetcode_75.Binary_search_tree;

import interview_questions.trees.TreeNode;

public class Delete_node_in_a_bst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            // In the case, both are null and one is null eitheir
            // Ignore the case root.left == null and root.right != null because I always consider the right side of the root
            // if (root.left == null){
            //     return root.right;
            // }
            if (root.right == null){
                return root.left;
            }

            TreeNode successor = findSuccessor(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
    private TreeNode findSuccessor(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
