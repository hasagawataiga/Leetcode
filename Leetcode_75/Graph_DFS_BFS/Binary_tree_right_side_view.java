package Leetcode_75.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import interview_questions.trees.TreeNode;

public class Binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if (i == 0){
                    list.add(temp.val);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                if (temp.left != null){
                    queue.offer(temp.left);
                }
            }
        }
        return list;
    }
}
