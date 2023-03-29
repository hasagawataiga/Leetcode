import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reducing_dishes {
    public int maxSatisfaction(int[] satisfaction) {
        // satisfaction = -Arrays.sort(-satisfaction);
        Arrays.sort(satisfaction);
        int[] dp = new int[satisfaction.length];
        List<Integer> dishes = new ArrayList<>();
        dp[dp.length - 1] = satisfaction[satisfaction.length - 1];
        dishes.add(dp.length - 1);
        for (int i = satisfaction.length - 2; i >= 0; i--){
            int max = maximumLikeTime(satisfaction, dp, dishes, i);
            System.out.println(max);
            if (max > dp[i + 1]){
                dp[i] = max;
                dishes.add(i);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0] > 0 ? dp[0] : 0;
    }
    private int maximumLikeTime(int[] satisfaction, int[] dp, List<Integer> dishes, int index){
        int max = 0;
        max += satisfaction[index] * 1;
        int times = 1;
        for (int i = dishes.size() - 1; i >= 0; i--){
            times++;
            max += satisfaction[dishes.get(i)] * times;
        }
        return max;
    }
}
