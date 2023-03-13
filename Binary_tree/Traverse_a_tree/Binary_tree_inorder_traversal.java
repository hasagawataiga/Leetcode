package Binary_tree.Traverse_a_tree;

import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

public class Binary_tree_inorder_traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return inorderTraversal(res, root);
    }
    private List<Integer> inorderTraversal(List<Integer> list, TreeNode node){
        if (node == null){
            return list;
        }
        if (node.left != null){
            inorderTraversal(list, node.left);
        }
        list.add(node.val);
        inorderTraversal(list, node.right);
        return list;
    }
}
