package Leetcode_75.Linked_list;

import interview_questions.linked_list.ListNode;

public class Reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prevNode = null;
        while(node != null){
            ListNode nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }
        return prevNode;
    }
}
