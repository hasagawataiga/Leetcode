import java.util.*;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    private final Set<TreeNode> infectionSet = new HashSet<>();
    private TreeNode startNode;
    private int start;

    public int amountOfTime(TreeNode root, int start) {
        this.start = start;
        setParentAndFindStart(root);
        return infect(startNode) - 1;
    }

    private void setParentAndFindStart(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val == start) {
            startNode = node;
        }
        TreeNode left = node.left;
        if (left != null) {
            parentMap.put(left, node);
            setParentAndFindStart(left);
        }
        TreeNode right = node.right;
        if (right != null) {
            parentMap.put(right, node);
            setParentAndFindStart(right);
        }
    }

    private int infect(TreeNode node) {
        if (node == null || infectionSet.contains(node)) {
            return 0;
        }
        infectionSet.add(node);
        int time1 = infect(parentMap.get(node));
        int time2 = infect(node.left);
        int time3 = infect(node.right);
        return 1 + Math.max(time1, Math.max(time2, time3));
    }
}