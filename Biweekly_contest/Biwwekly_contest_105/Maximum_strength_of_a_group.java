package Biweekly_contest.Biwwekly_contest_105;

import java.util.Arrays;

public class Maximum_strength_of_a_group {
    public long maxStrength(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        boolean isNonZero = false;
        Arrays.sort(nums);
        long res = 1;
        int index = nums.length - 1;
        while (index >= 0){
            if (nums[index] > 0){
                res *= nums[index];
                isNonZero = true;
            } else if (nums[index] == 0){
                index--;
                continue;
            } else {
                break;
            }
            index--;
        }
        // System.out.println(res);
        // int left = 0;
        long negativeProduct = 1;
        for (int i = 0; i <= index; i += 2){
            if (i + 1 <= index){
                negativeProduct *= nums[i] * nums[i + 1];
                isNonZero = true;
            }
        }
        res *= negativeProduct;
        return isNonZero ? res : 0;
    }
}
