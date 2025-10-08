import java.util.Arrays;

public class Successful_pairs_of_spells_and_potions {
    class Solution {
        int n;
        int m;
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            n = spells.length;
            m = potions.length;
            int[] ans = new int[n];
            Arrays.sort(potions);
            for (int i = 0; i < n; i++) {
                int leastPotion = findTheLeastPotion(spells, potions, spells[i], success);
                if (leastPotion != -1) {
                    ans[i] = m - leastPotion;
                }
            }

            return ans;
        }

        private int findTheLeastPotion(int[] spells, int[] potions, long spell, long success) {
            long product;
            int left = 0;
            int right = m - 1;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                product = spell * potions[mid];
                if (product >= success) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return res;
        }
    }
}
