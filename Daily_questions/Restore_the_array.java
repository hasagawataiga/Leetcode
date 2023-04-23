public class Restore_the_array {
    public int numberOfArrays(String s, int k) {
        // if (s.charAt() == '0'){
        //     return 0;
        // }
        int length = s.length();
        int[] dp = new int[length + 1];
        return dfs(dp, 0, s, length, k, (int)1e9 + 7);
    }
    private int dfs(int[] dp, int start, String s, int length, int k, int mod){
        if (start == length){
            return 1;
        }
        if (dp[start] != 0){
            return dp[start];
        }
        if (s.charAt(start) == '0'){
            return 0;
        }
        int count = 0;
        for (int end = start; end < length; ++end){
            String curr = s.substring(start, end + 1);
            if (Long.parseLong(curr) > k){
                break;
            }
            count = (count + dfs(dp, end + 1, s, length, k, mod)) % mod;
        }
        dp[start] = count;
        return count;
    }
}
