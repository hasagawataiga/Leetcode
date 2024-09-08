public class Split_linked_list_in_parts {
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            ListNode[] res = new ListNode[k];
            ListNode curr = head;
            int sum = 0;
            int[] boxes = new int[k];
            while (curr != null) {
                sum++;
                curr = curr.next;
            }
            calculate(boxes, sum, k);
            for (int i = 0; i < k; i++) {
                System.out.print(boxes[i] + ", ");
            }
            ListNode node = head;
            for (int i = 0; i < k; i++) {
                res[i] = node;
                int count = boxes[i];
                while (count-- > 1) {
    
                    node = node.next;
                    if (node.next == null) {
                        return res;
                    }
                }
                ListNode next = node.next;
                node.next = null;
                node = next;
            }
            return res;
        }
    
        private void calculate (int[] array, int sum, int k) {
            int average = sum / k;
            int slotLeft = sum % k;
            Arrays.fill(array, average);
            for (int i = 0; i < array.length; i++) {
                if (slotLeft-- == 0) {
                    break;
                }
                array[i]++;
            }
        }
    }
}
