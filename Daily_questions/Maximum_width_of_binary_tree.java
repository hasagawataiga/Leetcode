import java.util.LinkedList;
import java.util.Queue;

import interview_questions.trees.TreeNode;

// BFS approach
// Using 2 queues: queue (stores the TreeNode) and the indexes (stores the index of nodes)
// Rules: if the node has i-th index, its left node is 2*i + 1 and the right one is 2* + 2
// using BFS algorithm to traversal all nodes by level,
//      when reaching the last level, the width of this level would be the maximum width of this tree
//      find the left most and the right most nodes of the lastest level using the formula above.
// The maximum width is right - left + 1 (ignores the left most null and right most null followed the rule of question)
public class Maximum_width_of_binary_tree{
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Long> indexes = new LinkedList<>();
        queue.offer(root);
        indexes.offer((long)0);
        long left = 0;
        long right = 0;
        long max = 0;
        while (!queue.isEmpty()){
            long size = queue.size();
            left = indexes.peek();
            right = 0;
            for (long i = 0; i < size; i++){
                TreeNode node = queue.poll();
                long index = indexes.poll();
                if (i == size - 1){
                    right = index;
                }
                if (node.left != null){
                    queue.offer(node.left);
                    indexes.offer(2 * index + 1);
                }
                if (node.right != null){
                    queue.offer(node.right);
                    indexes.offer(2 * index + 2);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return (int)max;
    }
}