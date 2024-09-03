public class Sum_of_digits_of_string_after_convert {
    class Solution {
        public int getLucky(String s, int k) {
            int sum = 0;
            for (char ch : s.toCharArray()) {
                int val = ch - 'a' + 1;
                sum += sumOfDigits(val);
            }
            for (int i = 1; i < k; i++) {
                sum = sumOfDigits(sum);
            }
            return (int)sum;
        }
    
        private int sumOfDigits(long num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }
}
