import java.util.HashMap;
import java.util.Map;

public class Contiguous_array {
        public int findMaxLength(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int prefixSum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                prefixSum++;
            } else {
                prefixSum--;
            }
            if (prefixSum == 0) {
                max = Math.max(max, i + 1);
            } else {
                if (freq.containsKey(prefixSum)) {
                    max = Math.max(max, i - freq.get(prefixSum));
                } else {
                    freq.put(prefixSum, i);
                }
            }

        }
        return max;
    }
}
