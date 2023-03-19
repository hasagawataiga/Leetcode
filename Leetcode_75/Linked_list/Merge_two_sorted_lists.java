package Leetcode_75.Linked_list;

import interview_questions.linked_list.ListNode;

public class Merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pointer;
        if (list1 == null){
            return list2;
        } else if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            pointer = list1;
            list1 = list1.next;
        } else {
            pointer = list2;
            list2 = list2.next;
        }
        ListNode res = pointer;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                pointer.next = list1;
                pointer = pointer.next;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                pointer = pointer.next;
                list2 = list2.next;
            }
        }
        if (list1 == null){
            while (list2 != null){
                pointer.next = list2;
                pointer = pointer.next;
                list2 = list2.next;
            }
        } else {
            while (list1 != null){
                pointer.next = list1;
                pointer = pointer.next;
                list1 = list1.next;
            }
        }
        return res;
    }
}
