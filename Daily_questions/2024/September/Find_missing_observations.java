public class Find_missing_observations {
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int[] res = new int[n];
            int m = rolls.length;
            int total = (m + n) * mean;
            int sumOfM = 0;
            for (int i = 0; i < m; i++) {
                sumOfM += rolls[i];
            }
            int sumOfN = total - sumOfM;
            if (sumOfN > n * 6 || sumOfN < n) {
                return new int[0];
            }
            int[] dices = new int[7];
            int meanOfN = sumOfN / n;
            dices[meanOfN] = n;
            int leftValOfN = sumOfN - sumOfN / n * n;
            System.out.println(sumOfN + ": " + meanOfN + ", " + leftValOfN);
            while (leftValOfN > 0) {
                dices[meanOfN]--;
                dices[meanOfN + 1]++;
                leftValOfN--;
            }
            for (int i = 0; i < n; i++) {
                if (dices[meanOfN]-- > 0) {
                    res[i] = meanOfN;
                } else {
                    res[i] = meanOfN + 1;
                }
            }
            return res;
        }
    }
}
