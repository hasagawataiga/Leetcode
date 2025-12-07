package Daily_questions.Year_2025.December;

public class Count_odd_numbers_in_an_interval_range {
    class Solution {
        public int countOdds(int low, int high) {
            int count = (high - low + 1) / 2;
            if (low % 2 == 1 && high % 2 == 1) {
                count++;
            }

            return count;
        }
    }
}
