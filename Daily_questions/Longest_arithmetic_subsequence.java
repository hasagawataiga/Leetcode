

// Dynamic Approach
// 0 <= nums[i] <= 500  -> range = 500
// create 2D array named dp[n][range * 2 + 1]
//      range * 2 + 1: to store the diff between left and right values
public class Longest_arithmetic_subsequence {
    int range = 500;
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n < 2){
            return n;
        }
        int max = 0;
        // [n][range * 2 + 1]: 
        //  [n] store the index of right
        //  [range * 2 + 1] store the diff between left and right index
        int[][] dp = new int[n][range * 2 + 1];
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                // + range to ignore the case the diff is negative cause the out of index (array is 0-th index)
                int diff = nums[j] - nums[i] + range;
                if (dp[i][diff] == 0){
                    dp[i][diff] = 1;
                }
                dp[j][diff] = dp[i][diff] + 1;
                max = Math.max(max, dp[j][diff]);
            }
        }
        return max;
    }
}
