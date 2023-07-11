import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import interview_questions.trees.TreeNode;

public class All_nodes_distance_k_in_a_binary_tree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        // root == null
        if (root == null){
            return res;
        }
        // k == 0
        if (k == 0){
            res.add(target.val);
            return res;
        }
        // Tree has only 1 node
        if (root.left == null && root.right == null){
            if (k != 0){
                return res;
            } else {
                res.add(root.val);
                return res;
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(root.val, new ArrayList<>());
        createGraph(root, map);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target.val);
        boolean[] visited = new boolean[500];
        visited[target.val] = true;
        int stage = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int val = queue.poll();
                List<Integer> neighbors = map.get(val);
                for (int neighbor : neighbors){
                    if (!visited[neighbor]){
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            if (stage == k){
                for (int nodeVal : queue){
                    res.add(nodeVal);
                }
                return res;
            }
            stage++;
        }
        return res;
    }
    private void createGraph(TreeNode node, Map<Integer, List<Integer>> map){
        if (node.left != null){
            map.get(node.val).add(node.left.val);
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            map.put(node.left.val, temp);
            createGraph(node.left, map);
        }
        if (node.right != null){
            map.get(node.val).add(node.right.val);
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            map.put(node.right.val, temp);
            createGraph(node.right, map);
        }
    }
}
