

public class Partition_list{
    public ListNode partition(ListNode given, int x) {
        ListNode head = new ListNode(0);
        ListNode headCurr = head;
        ListNode tail = new ListNode(0);
        ListNode tailCurr = tail;
        while (given != null){
            if (given.val >= x){
                tailCurr.next = given;
                tailCurr = tailCurr.next;
            } else {
                headCurr.next = given;
                headCurr = headCurr.next;
            }
            given = given.next;
        }
        tailCurr.next = null;
        headCurr.next = tail.next;
        return head.next;
    }
}