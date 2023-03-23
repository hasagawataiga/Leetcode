package Algorithm_plan.Two_pointers;

import interview_questions.linked_list.ListNode;

public class Remove_nth_node_from_end_of_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        while (n > 0){
            second = second.next;
            n--;
        }
        if (second == null){
            return head.next;
        }
        while (second != null && second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
