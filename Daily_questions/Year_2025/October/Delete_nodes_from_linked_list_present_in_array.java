import interview_questions.linked_list.ListNode;

public class Delete_nodes_from_linked_list_present_in_array {
    class Solution {
        public ListNode modifiedList(int[] nums, ListNode head) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            int[] container = new int[max + 1];
            for (int num : nums) {
                container[num]++;
            }
            ListNode node = new ListNode();
            ListNode root = node;
            while (head != null) {
                if (head.val > max || container[head.val] == 0) {
                    ListNode curr = new ListNode();
                    curr.val = head.val;
                    node.next = curr;
                    node = node.next;
                }
                head = head.next;
            }
            return root.next;
        }
    }
}
