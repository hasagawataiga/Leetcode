package Leetcode_75.Heap;

import java.util.PriorityQueue;

public class K_th_largest_element_in_a_array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums){
            heap.add(num);
            if (heap.size() > k){
                heap.remove();
            }
        }
        return heap.peek();
    }
}
