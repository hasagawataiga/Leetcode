package Biweekly_contest.Biwwekly_contest_105;

public class Buy_two_chocolates {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int left = money - prices[0] - prices[1];
        if (left >= 0){
            money = left;
        }
        return money;
    }
}
