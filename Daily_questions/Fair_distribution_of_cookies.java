public class Fair_distribution_of_cookies {
    int average;
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int sum = 0;
        for (int num : cookies){
            sum += num;
        }
        average = sum / k;
        int[] dp = new int[n];
        return distribution(cookies, dp, 0, k, k);
        // printDp(dp);
        // int min = 0;
        // for (int i = 0; i < k; i++){
        //     min = Math.max(min, dp[n - 1][i]);
        // }
        // return min;
    }
    private int distribution(int[] cookies, int[] dp, int index, int zeroCount, int k){
        // If there are not enough cookies remaining, return Integer.MAX_VALUE
        // as it leads to an invalid distribution.
        if (cookies.length - index < zeroCount) {
            return Integer.MAX_VALUE;   
        }

        // After distributing all cookies, return the unfairness of this
        // distribution.
        if (index == cookies.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int value : dp) {
                unfairness = Math.max(unfairness, value);
            }
            return unfairness;
        }
        
        // Try to distribute the i-th cookie to each child, and update answer
        // as the minimum unfairness in these distributions.
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < k; ++j) {
            if (dp[j] == 0){
                zeroCount--;
            }
            if (dp[j] > average){
                continue;
            }
            dp[j] += cookies[index];
            
            // Recursively distribute the next cookie.
            res = Math.min(res, distribution(cookies, dp, index + 1, zeroCount, k));
            
            dp[j] -= cookies[index];

            if (dp[j] == 0){
                zeroCount++;
            }
        }
        
        return res;
    }
}
