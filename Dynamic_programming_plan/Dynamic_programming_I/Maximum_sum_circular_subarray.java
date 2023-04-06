package Dynamic_programming_plan.Dynamic_programming_I;

// Use Kadane algorithm to find the minSum and maxSum
public class Maximum_sum_circular_subarray {
    public int maxSubarraySumCircular(int[] nums) {
        int preSum = 0;
        int preSumMax = 0;
        int preSumMin = 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++){
            preSum += nums[i];
            preSumMax = Math.max(preSumMax, 0) + nums[i];
            preSumMin = Math.min(preSumMin, 0) + nums[i];
            min = Math.min(min, preSumMin);
            max = Math.max(max, preSumMax);
        }
        if (min == preSum){
            return max;
        } else {
            return Math.max(max, preSum - min);
        }
    }
}
