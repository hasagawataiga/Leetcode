package Algorithm_plan.Two_pointers;

import java.util.Arrays;

// Use 2 pointers
// Compare the squares of left and right
// Which one greater would be placed at the res index (start from the end of array)
public class Squares_of_a_sorted_array {
    public int[] sortedSquares(int[] nums) {
        int[] res = nums.clone();
        int left = 0;
        int right = nums.length - 1;
        int i = right;
        while (left <= right){
            int leftVal = nums[left] * nums[left];
            int rightVal = nums[right] * nums[right];
            if (leftVal > rightVal){
                res[i] = leftVal;
                left++;
            } else {
                res[i] = rightVal;
                right--;
            }
            i--;
        }
        return res;
    }
}
