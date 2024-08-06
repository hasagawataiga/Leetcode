import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

public class Balance_a_binary_search_tree {
    List<Integer> nodes;
    public TreeNode balanceBST(TreeNode root) {
        nodes = new ArrayList<>();
        traversal(root);
        for (int node : nodes) {
            System.out.print(node + ", ");
        }
        int size = nodes.size();
        int left = 0;
        int right = size - 1;
        int mid = left + (right - left) / 2;
        TreeNode newRoot = new TreeNode(nodes.get(mid));
        newRoot.left = buildBST(0, mid - 1);
        newRoot.right = buildBST(mid + 1, right);
        return newRoot;
    }
    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.left);
        nodes.add(node.val);
        traversal(node.right);
    }
    private TreeNode buildBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));
        node.left = buildBST(left, mid - 1);
        node.right = buildBST(mid + 1, right);
        return node;
    }
}