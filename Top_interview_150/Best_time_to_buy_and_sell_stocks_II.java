package Top_interview_150;

public class Best_time_to_buy_and_sell_stocks_II {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int left = 0;
        int right = 1;
        int profit = 0;
        while (right < length){
            int curr = prices[right] - prices[left];
            if (curr > 0){
                profit += curr;
            }
            left = right;
            right++;
        }
        return profit;
    }g
}
