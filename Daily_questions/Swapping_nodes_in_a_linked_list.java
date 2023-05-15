import interview_questions.linked_list.ListNode;

public class Swapping_nodes_in_a_linked_list {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (--k > 0){
            fast = fast.next;
        }
        ListNode firstNode = fast;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        int tempVal = firstNode.val;
        firstNode.val = slow.val;
        slow.val = tempVal;
        return head;
    }
}
