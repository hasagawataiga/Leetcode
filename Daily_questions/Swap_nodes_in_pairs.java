import interview_questions.linked_list.ListNode;

public class Swap_nodes_in_pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode nextNode = head.next;
        if (nextNode == null){
            head.next = null;
            return head;
        } else {
            head.next = swapPairs(head.next.next);
            nextNode.next = head;   
        }
        return nextNode;
    }
}
