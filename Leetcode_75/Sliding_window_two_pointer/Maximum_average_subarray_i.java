package Leetcode_75.Sliding_window_two_pointer;



public class Maximum_average_subarray_i {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i = 0;
        while (i < k){
            sum += nums[i];
            i++;
        }
        double res = sum;
        int j = 0;
        while (i < nums.length){
            sum -= nums[j];
            sum += nums[i];
            res = Math.max(res, sum);
            j++;
            i++;
        }
        return (double) res / k;
    }
}
