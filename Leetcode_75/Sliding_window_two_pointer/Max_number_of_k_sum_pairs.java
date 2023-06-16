package Leetcode_75.Sliding_window_two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Max_number_of_k_sum_pairs {
    public int maxOperations(int[] nums, int k) {
        
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < n; i++){
            if (k <= nums[i]){
                continue;
            }
            if (map.get(nums[i]) == 0){
                continue;
            }
            if (map.containsKey(k - nums[i]) && map.get(k - nums[i]) > 0){
                map.put(nums[i], map.get(nums[i]) - 1);
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
                // Ignore the case nums[i] = k / 2, it makes the amount of nums[i] be minused by 2
                // By checking the amount of nums[i], if it was greater than 0, then count++,
                //  otherwise, there is only one nums[i] left, we counld not make the operation.
                if (map.get(nums[i]) >= 0){
                    count++;
                }
            }
        }
        return count;
    }
}
