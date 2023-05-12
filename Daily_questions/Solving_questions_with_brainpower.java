
// Dynamic Programming approach
public class Solving_questions_with_brainpower {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        return mostPoints(questions, dp, 0, n);
     }
     private long mostPoints(int[][] questions, long[] dp, int i, int n){
         if (i >= n){
             return 0;
         }
         if (dp[i] != 0){
             return dp[i];
         }
         long included = questions[i][0] + mostPoints(questions, dp, i + questions[i][1] + 1, n);
         long excluded = mostPoints(questions, dp, i + 1, n);
         dp[i] = Math.max(included, excluded);
         return dp[i];
     }
}
