import java.util.Arrays;

public class Maximize_happiness_of_selected_children {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        // Arrays.sort(happiness, (b, a) -> Integer.compare(a, b));
        // Arrays.sort(happiness, Collections.reverseOrder());
        Arrays.sort(happiness);
        reverseArray(happiness);
        for (int i = 0; i < k; i++) {
            ans += happinessInTurn(happiness[i], i);
        }
        return ans;
    }
    private int happinessInTurn(int happiness, int turn) {
        return (happiness - turn) >= 0 ? happiness - turn : 0;
    }
    private void reverseArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    }
}