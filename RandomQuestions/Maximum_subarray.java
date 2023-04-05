package RandomQuestions;


// Kadane's algorithm
public class Maximum_subarray {
    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            preSum = Math.max(nums[i], preSum + nums[i]);
            max = Math.max(max, preSum);
            if (preSum < 0){
                preSum = 0;
            }
        }
        return max;
    }
}
