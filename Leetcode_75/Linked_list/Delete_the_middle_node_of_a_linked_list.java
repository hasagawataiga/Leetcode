package Leetcode_75.Linked_list;

import interview_questions.linked_list.ListNode;

public class Delete_the_middle_node_of_a_linked_list {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
