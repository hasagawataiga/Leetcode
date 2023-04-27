package Top_interview_150;

public class Best_time_to_buy_and_sell_stocks {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length){
            if (prices[left] > prices[right]){
                left = right;
            }
            profit = Math.max(profit, prices[right] - prices[left]);
            right++;
        }
        return profit;
    }
}
