import java.util.HashMap;
import java.util.Map;

public class Subarray_product_less_than_k {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findingSubarrayWithKUniques(nums, k) - findingSubarrayWithKUniques(nums, k - 1);
    }
    private int findingSubarrayWithKUniques(int[] nums, int k) {
        Map<Integer, Integer> container = new HashMap<>();
        int first = 0;
        int second = 0;
        int length = nums.length;
        int uniques = 0;
        int count = 0;
        while (second < length) {
            container.put(nums[second], container.getOrDefault(nums[second], 0) + 1);
            if (container.get(nums[second]) == 1) {
                uniques++;
            }
            while (uniques > k) {
                container.put(nums[first], container.get(nums[first]) - 1);
                if (container.get(nums[first]) == 0) {
                    uniques--;
                }
                first++;
            }
            count += (second - first + 1);
            second++;
        }        
        return count;
    }
}
