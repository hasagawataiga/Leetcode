package Programming_skills_plan.Programming_skills_I;

import interview_questions.linked_list.ListNode;

public class Add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode node = res;
        int extra = 0;
        while (l1 != null && l2 != null){
            ListNode next = new ListNode();
            node.next = next;
            node = node.next;
            int val = l1.val + l2.val + extra;
            if (val > 9){
                extra = 1;
                val %= 10;
            } else {
                extra = 0;
            }
            node.val = val;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            ListNode next = new ListNode();
            node.next = next;
            node = node.next;
            int val = l1.val + extra;
            if (val > 9){
                extra = 1;
                val %= 10;
            } else {
                extra = 0;
            }
            node.val = val;
            l1 = l1.next;
            
        }
        while (l2 != null){
            ListNode next = new ListNode();
            node.next = next;
            node = node.next;
            int val = l2.val + extra;
            if (val > 9){
                extra = 1;
                val %= 10;
            } else {
                extra = 0;
            }
            node.val = val;
            l2 = l2.next;
        }
        if (extra == 1){
            ListNode next = new ListNode();
            node.next = next;
            next.val = 1;
        }
        return res.next;
    }
}
