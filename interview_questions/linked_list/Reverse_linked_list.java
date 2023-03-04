package interview_questions.linked_list;

public class Reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        ListNode pointer = head;
        ListNode pointer2 = null;
        while (pointer != null){
            ListNode nextNode = pointer.next;
            pointer.next = pointer2;
            pointer2 = pointer;
            pointer = nextNode;
            
        }
        return pointer2;
    }
}
