import java.util.Arrays;

public class Maximize_happiness_of_selected_children {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        // Arrays.sort(happiness, (b, a) -> Integer.compare(a, b));
        // Arrays.sort(happiness, Collections.reverseOrder());
        int length = happiness.length;
        Arrays.sort(happiness);
        int turns = 0;
        for (int i = length - 1; i >= length - k; i--) {
            int val = happiness[i] - turns++;
            if (val > 0) {
                ans += val;
            } else {
                break;
            }
        }
        return ans;
    }
}