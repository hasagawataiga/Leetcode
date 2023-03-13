package RandomQuestions;

import interview_questions.linked_list.ListNode;

// Using 2 pointers: slow and fast
// slow: 1 node/move
// fast: 2 nodes/move
// when fast node reachs the end of linkedlist, slow node is at middle position of linkedlists
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
