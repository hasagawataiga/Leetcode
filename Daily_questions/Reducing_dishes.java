import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reducing_dishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        int runningTime = 0;
        int sumSatisfactionDishes = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--){
            sumSatisfactionDishes += satisfaction[i];
            runningTime += sumSatisfactionDishes;
            max = Math.max(max, runningTime);
        }
        return max;
    }
}
