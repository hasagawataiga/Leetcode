package Recursion.Conclusion;

import interview_questions.linked_list.ListNode;

public class Merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        if (list1 == null && list2 == null){
            return null;
        }
        if (list1 == null){
            node = list2;
            list2 = list2.next;
            node.next = mergeTwoLists(list1, list2);
            return node;
        }
        if (list2 == null){
            node = list1;
            list1 = list1.next;
            node.next = mergeTwoLists(list1, list2);
            return node;
        }
        if (list1.val < list2.val){
            node = list1;
            list1 = list1.next;
        } else {
            node = list2;
            list2 = list2.next;
        }
        node.next = mergeTwoLists(list1, list2);
        return node;
    }
}
