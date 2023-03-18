package Biweekly_contest.Contest_100;

import java.util.Arrays;

public class Maximize_greatness_of_an_array {
    public int maximizeGreatness(int[] nums) {
        int count = 0;
        int length = nums.length;
        if (length < 2){
            return 0;
        }
        // Sort the array in ascending order
        Arrays.sort(nums);
        // Use 2 pointers:
        //  1. move 1 step to the left every loop
        //  2. move 1 step to the left whenever nums[pointer1] < nums[pointer2]
        //  In details, when nums[pointer1] >= nums[pointer2], it means that this pair is not satisfied the condition
        //      then we move pointer1 until the proper pair then pointer2--
        int pointer1 = length - 1;
        int pointer2 = length - 1;
        while (pointer1 >= 0){
            if (nums[pointer1] < nums[pointer2]){
                pointer2--;
                count++;
            }
            pointer1--;
        }
        return count;
    }
}
