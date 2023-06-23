package Leetcode_75.Heap;

import java.util.PriorityQueue;

public class K_th_largest_element_in_a_array {
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> heap = new PriorityQueue<>();
    //     for (int num : nums){
    //         heap.add(num);
    //         if (heap.size() > k){
    //             heap.remove();
    //         }
    //     }
    //     return heap.peek();
    // }
    public int findKthLargest(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for (int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] count = new int[max - min + 1];
        for (int num : nums){
            count[num - min]++;
        }
        for (int i = count.length - 1; i >= 0; i--){
            k -= count[i];
            if (k <= 0){
                return i + min;
            }
        }
        return -1;
    }
}
