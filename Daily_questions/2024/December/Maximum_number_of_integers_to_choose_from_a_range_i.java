public class Maximum_number_of_integers_to_choose_from_a_range_i {
    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            boolean[] isBanned = new boolean[n + 1];
    
            for (int i = 0; i < banned.length; i++) {
                if (banned[i] > n) {
                    continue;
                }
                isBanned[banned[i]] = true;
            }
    
            int count = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (!isBanned[i]) {
                    if (sum + i > maxSum) {
                        return count;
                    } else {
                        count++;
                        sum += i;
                    }
                }
            }
    
            return count;
        }
    }
}
