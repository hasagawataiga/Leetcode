package RandomQuestions;

import java.util.ArrayList;
import java.util.List;

import interview_questions.trees.TreeNode;

// Using DFS algorithm
public class Binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode node, int level, List<List<Integer>> res){
        if (res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        if (node.left != null){
           dfs(node.left, level + 1, res); 
        }
        if (node.right != null){
            dfs(node.right, level + 1, res);
        }
    }
}
