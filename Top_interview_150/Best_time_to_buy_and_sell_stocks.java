package Top_interview_150;

public class Best_time_to_buy_and_sell_stocks {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 0;
        while (right < prices.length){
            int buy = prices[buy];
            while (right < prices.length && prices[right] >= prices[left]){
                right++;
            }
            profit += prices[right]
        }
        return profit;
    }
}
