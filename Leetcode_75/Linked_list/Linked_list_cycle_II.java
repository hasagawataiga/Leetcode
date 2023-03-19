package Leetcode_75.Linked_list;

import interview_questions.linked_list.ListNode;

// Use 2 pointers: slow (move 1 per step) and fast (move 2 per step)
// when 2 pointers reach eachother means that the linked list has a cycle
// reset the slow to the head and keep the fast still stand there
// Continuing iteration again with the same pace for both pointer until they reach others
public class Linked_list_cycle_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                break;
            }
        }
        while (slow != null && fast != null){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return null;
    }
}
