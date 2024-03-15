import java.util.HashMap;
import java.util.Map;

public class Binary_subarrays_with_sum {
        public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> frequence = new HashMap<>();
        int prefixSum = 0;
        int total = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSum == goal) {
                total++;
            }
            if (frequence.containsKey(prefixSum - goal)) {
                total += frequence.get(prefixSum - goal);
            }
            frequence.put(prefixSum, frequence.getOrDefault(prefixSum, 0) + 1);
        }
        return total;
    }
}
