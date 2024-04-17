import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

public class Smallest_string_starting_from_leaf {
    List<String> strings;
    public String smallestFromLeaf(TreeNode root) {
        strings = new ArrayList<>();
        traversal(root, new StringBuilder());
        String ans = strings.get(0);
        for (String string : strings) {
            if (ans.compareTo(string) > 0) {
                ans = string;
            }
        }
        return ans;
    }
    private void traversal(TreeNode node, StringBuilder sb) {
        sb.append((char)(node.val + 'a'));
        if (node.left == null && node.right == null) {
            strings.add(sb.reverse().toString());
            return;
        }
        if (node.left != null) {
            traversal(node.left, new StringBuilder(sb));
        }
        if (node.right != null) {
            traversal(node.right, new StringBuilder(sb));
        }
    }
}
