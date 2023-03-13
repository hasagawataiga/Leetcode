package Binary_tree.Traverse_a_tree;

import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

public class Binary_tree_postorder_traveral {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return postorderTraveral(res, root);
    }
    private List<Integer> postorderTraveral(List<Integer> list, TreeNode node){
        if (node == null){
            return list;
        }
        if (node.left != null){
            postorderTraveral(list, node.left);
        }
        if (node.right != null){
            postorderTraveral(list, node.right);
        }
        list.add(node.val);
        return list;
    }
}
