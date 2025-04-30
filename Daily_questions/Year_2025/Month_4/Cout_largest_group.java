import java.util.HashMap;
import java.util.Map;

public class Cout_largest_group {
    class Solution {
        public int countLargestGroup(int n) {
            int count = 0;

            int max = 0;
            Map<Integer, Integer> groups = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                int sumDigit = sumDigits(i);
                int currentVal = 0;
                if (groups.containsKey(sumDigit)) {
                    int prevSum = groups.get(sumDigit);
                    currentVal = prevSum;
                    groups.put(sumDigit, prevSum + 1);
                } else {
                    groups.put(sumDigit, 1);
                }
                max = Math.max(max, currentVal + 1);
            }

            for (Map.Entry<Integer, Integer> entry : groups.entrySet()) {
                if (entry.getValue() == max) {
                    count++;
                }
            }

            return count;
        }

        private int sumDigits(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

    }
}
