public class Remove_zero_sum_consecutive_nodes_from_linked_list {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode before = new ListNode(0);
        before.next = head;
        ListNode start = before;
        while (start != null) {
            int prefix = 0;
            ListNode end = start.next;
            while (end != null) {
                prefix += end.val;
                if (prefix == 0) {
                    start.next = end.next;
                
                }
                end = end.next;
            }
            start = start.next;
        }
        // while (before.next != null && before.next.val == 0) {
        //     before = before.next;
        // }
        return before.next;
    }
}
