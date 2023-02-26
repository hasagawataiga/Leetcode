package InterviewQuestions;


class ListNode {
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
        int extraPoint = 0;
        while(!(l1 == null && l2 == null)){
            int val1 = 0;
            if(l1 != null)
            {
                val1 = l1.val;
                l1 = l1.next;
            }
            int val2 = 0;
            if(l2 != null)
            {
                val2 = l2.val;
                l2 = l2.next;
            }
            int ans = extraPoint + val1 + val2;
            extraPoint = ans/10;
            curr.next = new ListNode(ans%10);
            curr = curr.next;
        }
        if(extraPoint == 1){
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}