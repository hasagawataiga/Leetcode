import java.util.Stack;

import interview_questions.linked_list.ListNode;

public class Remove_nodes_from_linked_list {
        public ListNode removeNodes(ListNode head) {
        ListNode ans = head;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        ListNode next = head.next;
        while (next != null) {
            while (!stack.isEmpty() && next.val > stack.peek().val) {
                ListNode node = stack.pop();
                node.val = next.val;
                node.next = next.next;
                next = node;
            }
            stack.push(next);
            next = next.next;
        }
        return ans;
    }
}
