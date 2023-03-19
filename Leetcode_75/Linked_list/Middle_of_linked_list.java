package Leetcode_75.Linked_list;

import interview_questions.linked_list.ListNode;

// Use 2 pointer2: slow(move 1 per step) and fast(move 2 per step)
//  when fast reaches the end of linked list, the slow is at the middle of linked list
public class Middle_of_linked_list {
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
