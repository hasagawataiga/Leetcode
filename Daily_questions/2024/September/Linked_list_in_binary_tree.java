import interview_questions.linked_list.ListNode;
import interview_questions.trees.TreeNode;

public class Linked_list_in_binary_tree {
    class Solution {
        public boolean isSubPath(ListNode head, TreeNode node) {
            if (head == null) {
                return true;
            }
            if (node == null) {
                return false;
            }
            if (dfs(head, node)) {
                return true;
            }
            return isSubPath(head, node.left) || isSubPath(head, node.right);
        }
    
        private boolean dfs(ListNode head, TreeNode node) {
            if (head == null) {
                return true;
            }
            if (node == null) {
                return false;
            }
            if (node.val != head.val) {
                return false;
            }
            return dfs(head.next, node.left) || dfs(head.next, node.right);
        }
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
