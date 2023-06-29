package Leetcode_75.Dynamic_programming;

public class N_th_tribonacci_number {
    int[] nums = new int[39];
    public int tribonacci(int n) {
        if (n == 0 || n == 1){
            nums[n] = n;
            return nums[n];
        }
        if (n == 2){
            nums[n] = 1;
            return nums[n];
        }
        if (nums[n - 1] == 0){
            nums[n - 1] = tribonacci(n - 1);
        }
        if (nums[n - 2] == 0){
            nums[n - 2] = tribonacci(n - 2);
        }
        if (nums[n - 3] == 0){
            nums[n - 3] = tribonacci(n - 3);
        }
        return nums[n - 1] + nums[n - 2] + nums[n - 3];
    }
}
