import java.util.PriorityQueue;

public class K_th_largest_element_in_stream {
    class KthLargest {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++){
                heap.offer(nums[i]);
                // if (i >= k){
                //     heap.poll();
                // }
            }
        }
        
        public int add(int val) {
            heap.offer(val);
            while (heap.size() > k){
                heap.poll();
            }
            return heap.peek();
        }
    }
    
}
