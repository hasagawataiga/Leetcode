package Contest.Contest_350;

import java.util.Arrays;

public class Find_The_value_of_the_partition {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        if (n < 2){
            return Math.abs(nums[0] - nums[1]);
        }
        Arrays.sort(nums);
        int min = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++){
            min = Math.min(min, nums[i] - nums[i - 1]);
        }
        return min;
    }
}
