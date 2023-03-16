package interview_questions.array;

import java.util.HashMap;

public class Two_sum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> container = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            if(container.containsKey(difference)){
                res[0] = container.get(difference);
                res[1] = i;
                return res;
            } else {
                container.put(nums[i], i);
            }
        }
        return res;
    }
}
