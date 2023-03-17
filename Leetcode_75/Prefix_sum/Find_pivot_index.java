package Leetcode_75.Prefix_sum;

public class Find_pivot_index {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1){
            return 0;
        }
        for (int i = 0; i < length; i++){
            int sumLeft = 0;
            for (int j = 0; j < i; j++){
                sumLeft += nums[j];
            }
            int sumRight = 0;
            for (int k = i + 1; k < length; k++){
                sumRight += nums[k];
            }
            if (sumLeft == sumRight){
                return i;
            }
        }
        return -1;
    }
}
