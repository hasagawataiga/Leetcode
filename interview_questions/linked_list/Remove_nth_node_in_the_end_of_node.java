package interview_questions.linked_list;
public class Remove_nth_node_in_the_end_of_node {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        // 1 < n, in this case if head length is 1, return null.
        if (head.next == null){
            return null;
        }
        // Let the fastPointer go n-th steps further than the slowPointer
        while (n > 0){
            if (fastPointer.next == null){
                return head.next;
            }
            fastPointer = fastPointer.next;
            n--;
        }
        // both pointers would go together until the fastPointer reaches the end of the ListNode
        while (fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        // remove the node right after the slowPointer
        slowPointer.next = slowPointer.next.next;
        return head;
    }
}