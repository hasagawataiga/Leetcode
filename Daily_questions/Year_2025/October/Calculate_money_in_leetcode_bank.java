public class Calculate_money_in_leetcode_bank {
    class Solution {
        public int totalMoney(int n) {
            int total = 0;
            int weeks = n / 7;
            total += weeks * 28;
            for (int i = 1; i < weeks; i++) {
                total += 7 * i;
            }
            
            int leftDays = n % 7;
            for (int i = 1; i <= leftDays; i++) {
                total += weeks + i;
            }

            return total;
        }
    }
}
