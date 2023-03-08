package interview_questions.linked_list;

public class Merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pointer;
        if (list1 == null){
            return list2;
        } else if (list2 == null){
            return list1;
        }
        // Init the first element for the res ListNode
        if (list1.val < list2.val){
            pointer = list1;
            list1 = list1.next;
        } else {
            pointer = list2;
            list2 = list2.next;
        }
        ListNode res = pointer;
        // Sorted every single elements from both ListNodes to the res ListNode
        // util the end of the shorter ListNode
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
        // Merge the rest of the longer ListNode to res ListNode
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
