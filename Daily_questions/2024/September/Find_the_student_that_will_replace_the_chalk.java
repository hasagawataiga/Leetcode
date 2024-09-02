public class Find_the_student_that_will_replace_the_chalk {
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            int studentReplaceChalk = -1;
            long sumChalkPerTurn = 0;
            for (int i = 0; i < chalk.length; i++) {
                sumChalkPerTurn += chalk[i];
            }
            int chalkLeft = k;
            if (sumChalkPerTurn < k) {
                chalkLeft = k - (int)(k / sumChalkPerTurn * sumChalkPerTurn);
            }
            if (chalkLeft == 0) {
                return 0;
            }
            for (int i = 0; i < chalk.length; i++) {
                if (chalkLeft < chalk[i]) {
                    return i;
                }
                chalkLeft -= chalk[i];
            }
            return 0;
        }
    }
}
