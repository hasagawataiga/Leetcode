package Leetcode_75.Linked_list;

import interview_questions.linked_list.ListNode;

public class Odd_even_linked_list {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && slow.next != null && fast != null && fast.next != null){
            slow.next = slow.next.next;
            slow = slow.next;
            fast.next = fast.next.next;
            fast = fast.next;
        }
        slow.next = even;
        return odd;
    }
}
