package Binary_tree.Traverse_a_tree;

import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

public class Binary_tree_preorder_traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(res, root);
        return res;
    }
    private List<Integer> traversal(List<Integer> list, TreeNode node){
        if (node != null){
            list.add(node.val);
            traversal(list, node.left);
            traversal(list, node.right);
        }
        return list;
    }
}
