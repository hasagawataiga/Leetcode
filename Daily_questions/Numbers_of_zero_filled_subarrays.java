package aily_questions;

public class Numbers_of_zero_filled_subarrays{
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        int index = 0;
        while (index < nums.length){
            long count = 0;
            while (index < nums.length && nums[index] == 0){
                count++;
                index++;
            }
            while (count > 0){
                sum += count--;
            }
            index++;
        }
        return sum;
    }
}