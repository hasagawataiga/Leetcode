package Biweekly_contest.Biweekly_contest_102;

import java.util.LinkedList;
import java.util.Queue;

import interview_questions.trees.TreeNode;


// BFS approach
// When store the children of a node, change the val of this child with the sum of all children of its parent
//      5   ->  5
//     / \     / \
//    3   4   7   7
// Then add the value of its into the sum variable
// After traverse all the children at the same level
// preSum = sum to use it when the queue poll the children at this level later
//      because we have to reset the sum to 0 after that to store another sum for the lower level
//      increase sum and traverse the children will be done at the same time, so we have to create a variable preSum
// Then reaching the lower level, just minus the preSum (sum of upper level) to the val of this node (the val of this node has been changed to the sum of children of this node parent already)


public class Cousins_in_binary_tree_II {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        int preSum = root.val;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                node.val = preSum - node.val;
                if (node.left != null && node.right != null){
                    sum += node.left.val;
                    sum += node.right.val;
                    int temp = node.left.val;
                    node.left.val = node.left.val + node.right.val;
                    node.right.val = node.right.val + temp;
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else if (node.right != null){
                    sum += node.right.val;
                    queue.offer(node.right);
                } else if (node.left != null){
                    sum += node.left.val;
                    queue.offer(node.left);
                }
            }
            preSum = sum;
            sum = 0;
        }
        return root;
    }
}
