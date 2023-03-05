package interview_questions.linked_list;

import java.util.Stack;

public class Palindrome_linked_list {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        Stack<Integer> stacks = new Stack<>();
        // Find the middle of linked list by use 2 pointers
        // when the fastPointer reachs the end of linked list, the slowPointer is in the middle
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null){
            stacks.push(slowPointer.val);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        // In the case the length of linked list is odd, when the fastPointer reachs the end of linked list,
        // the slowPointer is one node before the middle, then we ignore the next node.
        if (fastPointer != null){
            slowPointer = slowPointer.next;
        }
        // Check the rest of linked list (1/2 the whole linked list) by remove elements one by one,
        // and compares it to the slowPointer value
        while (slowPointer != null){
            if (stacks.pop() != slowPointer.val){
                return false;
            }
            slowPointer = slowPointer.next;
        }
        return true;
    }
}
