package Daily_questions;
import interview_questions.linked_list.ListNode;

public class Merge_k_sorted_lists {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length < 1){
            return null;
        }
        int interval = 1;
        // Divide and conquer algorithm
        // interval is the length of groups which will be divided every loop
        // 0 1 2 3 4 5
        //  0   2   4   (interval == 1)
        //    0   4     (interval == 2)
        //      0       (interval == 4)
        // until the array has only 1 element left
        while (interval < length){
            for (int i = 0; i < (length - interval); i = i + (interval*2)){
                lists[i] = mergeListNodes(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeListNodes (ListNode node1, ListNode node2){
        if (node1 == null && node2 == null){
            return null;
        }
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        ListNode res;
        if (node1.val < node2.val){
            res = node1;
            node1 = node1.next;
        } else {
            res = node2;
            node2 = node2.next;
        }
        ListNode head = res;
        while (node1 != null && node2 != null){
            if (node1.val <= node2.val){
                res.next = node1;
                res = res.next;
                node1 = node1.next;
            } else {
                res.next = node2;
                res = res.next;
                node2 = node2.next;
            }
        }
        if (node1 != null){
            res.next = node1;
        }
        if (node2 != null){
            res.next = node2;
        }
        return head;
    }
}
