import interview_questions.linked_list.ListNode;

public class Merge_in_between_linked_lists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        while (list1.next != null && a > 1) {
            list1 = list1.next;
            a--;
            b--;
        }
        ListNode start = list1;
        // Find attach placement of list1 & list2
        while (start.next != null && b > 0) {
            start = start.next;
            b--;
        }
        // Attach the start of list2 to list1
        list1.next = list2;
        // Find the end of list2
        while (list2.next != null) {
            list2 = list2.next;
        }
        // Attach the end of list2 to list1
        list2.next = start.next;
        return head;
    }
}
