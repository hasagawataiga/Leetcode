package Programming_skills_plan.Programming_skills_I;

import java.util.Stack;

import interview_questions.linked_list.ListNode;

public class Add_two_numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        while (l1 != null){
            num1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            num2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = new ListNode();
        int extra = 0;
        while (!num1.isEmpty() && !num2.isEmpty()){
            res.val = num1.pop() + num2.pop() + extra;
            extra = res.val / 10;
            res.val %= 10;
            ListNode prev = new ListNode();
            prev.next = res;
            res = prev;
        }
        while (!num1.isEmpty()){
            res.val = num1.pop() + extra;
            extra = res.val / 10;
            res.val %= 10;
            ListNode prev = new ListNode();
            prev.next = res;
            res = prev;
        }
        while (!num2.isEmpty()){
            res.val = num2.pop() + extra;
            extra = res.val / 10;
            res.val %= 10;
            ListNode prev=  new ListNode();
            prev.next = res;
            res = prev;
        }
        if (extra > 0){
            res.val = extra;
            return res;
        } else {
            return res.next;
        }
    }
}
