package Dynamic_programming_plan.Dynamic_programming_I;



// 2223334
// dp[1:0, 2:3, 3:3, 4:1]
// maxPointsInclusive = 0;  maxPointsNonInclusive = 0;
//      preMaxPointsNonInclusive = maxPointsNonInclusive; (dp[i - 1])
//      maxPointsNonInclusive = max(maxPointsInclusive, maxPointNonInclusive)
//              dp[i]         = max(included dp[i - 1], non-included dp[i-1]);   (max(...) is the maxPoints at dp[i - 1])
//      if (dp[i] > 0) -> maxPointsInclusive = preMaxPointsNonInclusive + dp[i] * i;
//              |                     |                     |                  |
//     dp[i] == 0, means there        |                     |              numCount * val
//      are such no this number       |                     |
//           in nums                  |               Non-Included dp[i - 1]
//                                    |
//                              Included dp[i]
public class Delete_and_earn{
    public int deleteAndEarn(int[] nums) {
        // Preprocess the input array to count the number of times each element appears
        int[] dp = new int[10001];
        for (int num : nums) {
            dp[num]++;
        }
        int maxPointsInclusive = 0;
        int maxPointsNonInclusive = 0;
        for (int i = 1; i < 10001; i++){
            int preMaxPointsNonInclusive = maxPointsNonInclusive; //points of ignoring dp[i - 1]
            maxPointsNonInclusive = Math.max(maxPointsInclusive, maxPointsNonInclusive);    // points of ignoring dp[i]
            if (dp[i] > 0){
                maxPointsInclusive = preMaxPointsNonInclusive + dp[i] * i; // points of including dp[i]: = dp[i]*i + maxPointsNonInclusive (ignore dp[i - 1])
            }
        }
        // Return the maximum score we can achieve
        return Math.max(maxPointsInclusive, maxPointsNonInclusive);
    }
}