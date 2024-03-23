import interview_questions.linked_list.ListNode;

public class Reorder_list {
        public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode headSecond = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode tail = reverseList(slow);
        while (tail != null) {
            ListNode headNext = headSecond.next;
            headSecond.next = tail;
            headSecond = tail;
            tail = headNext;
        }
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
