

// Dynamic Programming approach
public class Count_ways_to_build_good_strings {
    int mod = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i < high + 1; i++){
            if (i >= zero){
                dp[i] += dp[i - zero];
            }
            if (i >= one){
                dp[i] += dp[i - one];
            }
            dp[i] %= mod;
        }
        int res = 0;
        for (int i = low; i <= high; i++){
            res += dp[i];
            res %= mod;
        }
        return res;
    }
}
