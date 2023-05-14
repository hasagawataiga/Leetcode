package Contest.Contest345;


// Dynamic programming approach
public class Neighboring_bitwise_xor {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 0; i < n; i++){
            if (dp[i][0] != derived[i]){
                dp[i + 1][0] = 1;
            } else {
                dp[i + 1][0] = 0;
            }
            if (dp[i][1] != derived[i]){
                dp[i + 1][1] = 1;
            } else {
                dp[i + 1][1] = 0;
            }
        }
        boolean res = false;
        if (dp[n][0] == dp[0][0]){
            res = true;
        }
        if (dp[n][1] == dp[0][1]){
            res = true;
        }
        return res;
    }
}
