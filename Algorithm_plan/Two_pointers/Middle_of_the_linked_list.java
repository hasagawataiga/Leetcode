package Algorithm_plan.Two_pointers;

import interview_questions.linked_list.ListNode;

public class Middle_of_the_linked_list {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
