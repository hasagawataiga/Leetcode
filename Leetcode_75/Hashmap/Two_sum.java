package Leetcode_75.Hashmap;

import java.util.HashMap;

public class Two_sum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> container = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            if (container.containsKey(num)){
                res[0] = container.get(num);
                res[1] = i;
                return res;
            } else {
                container.put(target - num, i);
            }
        }
        return res;
    }
}
