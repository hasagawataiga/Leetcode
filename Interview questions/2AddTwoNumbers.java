
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        ListNode index1 = l1;
        ListNode index2 = l2;
        int extraPoint = 0;
        while(!(index1 == null && index2 == null)){
            int val1 = 0;
            if(index1 != null)
            {
                val1 = index1.val;
                index1 = index1.next;
            }
            int val2 = 0;
            if(index2 != null)
            {
                val2 = index2.val;
                index2 = index2.next;
            }
            int ans = extraPoint + val1 + val2;
            extraPoint = 0;
            if(ans > 9){
                ans = ans - 10;
                extraPoint = 1;
            }
            curr.next = new ListNode(ans);
            curr = curr.next;
        }
        if(extraPoint == 1){
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}