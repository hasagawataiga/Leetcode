import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interview_questions.trees.TreeNode;

public class Find_mode_in_binary_search_tree {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    private void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        dfs(node.left, map);
        dfs(node.right, map);
    }
}
