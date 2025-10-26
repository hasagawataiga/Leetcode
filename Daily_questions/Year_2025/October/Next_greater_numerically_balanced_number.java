public class Next_greater_numerically_balanced_number {
    class Solution {
        int max = 10_000_001;
        public int nextBeautifulNumber(int n) {
            for (int i = n + 1; i < max; i++) {
                if (isBalanced(i)) {
                    return i;
                }
            }

            return 1;
        }

        private boolean isBalanced(int n) {
            int[] digits = new int[10];
            while (n > 0) {
                digits[n % 10]++;
                n /= 10;
            }

            if (digits[0] != 0) {
                return false;
            }

            for (int i = 1; i < digits.length; i++) {
                if (digits[i] == 0) {
                    continue;
                }
                if (digits[i] != i) {
                    return false;
                }
            }

            return true;
        }
    }
}
