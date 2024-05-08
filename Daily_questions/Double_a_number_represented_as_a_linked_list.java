import java.util.Stack;

import interview_questions.linked_list.ListNode;

public class Double_a_number_represented_as_a_linked_list {
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            head.val *= 2;
            stack.push(head);
            head = head.next;
        }
        ListNode curr = null;
        int extra = 0;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.val += extra;
            extra = 0;
            if (curr.val > 9) {
                extra = curr.val / 10;
                curr.val = curr.val % 10;
            }
        }
        if (extra != 0) {
            return new ListNode(extra, curr);
        }
        return curr;
    }
}
