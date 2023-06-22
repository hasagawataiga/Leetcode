public class Best_time_to_buy_and_sell_stock_with_transaction_fee {
    // Dynamic Programming approach
    // there are 3 actions we could do with any day of the array:
    //  1. free the stock
    //  2. hold the stock
    //  3. do nothing (skip it)
    // Create a dp array to store the free and hold value for i-th day
    // then iterate through the array and update the max ones for those values.
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // Free
        dp[0][0] = 0;
        // Hold
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    // Greedy Approach
    public int maxProfit2(int[] prices, int fee) {
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > buy + fee) {
                profit += prices[i] - buy - fee;
                buy = prices[i] - fee;
            }
        }
        return profit;
    }
}
