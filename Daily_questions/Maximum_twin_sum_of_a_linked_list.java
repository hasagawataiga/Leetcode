import java.util.Stack;

import interview_questions.linked_list.ListNode;

public class Maximum_twin_sum_of_a_linked_list {
    public int pairSum(ListNode head) {
        int sum = 0;
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null){
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null && !stack.isEmpty()){
            int twin = stack.pop();
            sum = Math.max(sum, twin + slow.val);
            slow = slow.next;
        }
        return sum;
    }
}
