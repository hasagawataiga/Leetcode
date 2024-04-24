public class N_th_tribonacci_number {
    int[] dp = new int[38];
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = tribonacci(n - 3) + tribonacci(n - 1) + tribonacci(n - 2);
        return dp[n];
    }
}
