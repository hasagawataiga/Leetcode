package Data_structure_plan.Data_structure_I;

import interview_questions.linked_list.ListNode;

public class Remove_linked_list_elements {
    public ListNode removeElements(ListNode head, int val) {
        // if (head == null){
        //     return null;
        // }
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            if (curr.val == val && prev != null){
               prev.next = curr.next;
               curr = prev.next; 
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
