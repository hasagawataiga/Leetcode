package interview_questions.dynamic_programming;

public class Best_time_to_buy_and_sell_stocks {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices){
            if (price < minPrice){
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
