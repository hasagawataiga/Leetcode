package Daily_questions.Year_2025.September;

public class Find_n_unique_integers_sum_up_to_zero {
    class Solution {
        public int[] sumZero(int n) {
            int[] res = new int[n];
            int mid = n / 2;
            int curr = n;
            for (int i = 0; i < mid; i++) {
                res[i] = curr * (-1);
                res[n - i - 1] = curr;
                curr--;
            }
            
            return res;
        }
    }
}
