import java.util.HashMap;
import java.util.Map;

public class Length_of_longest_subarray_with_at_most_k_frequence {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int first = 0;
        int second = 0;
        Map<Integer, Integer> container = new HashMap<>();
        while (second < nums.length) {
            container.put(nums[second], container.getOrDefault(nums[second], 0) + 1);
            while (container.get(nums[second]) > k) {
                container.put(nums[first], container.get(nums[first]) - 1);
                first++;
            }
            max = Math.max(max, second - first + 1);
            second++;
        }
        return max;
    }
}
