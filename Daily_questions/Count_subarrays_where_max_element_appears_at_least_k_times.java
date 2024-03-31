import java.util.Arrays;

public class Count_subarrays_where_max_element_appears_at_least_k_times {
        public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        long res = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            k -= nums[right] == mx ? 1 : 0;
            right++;
            while (k == 0) {
                k += nums[left] == mx ? 1 : 0;
                left++;
            }
            res += left;
        }
        
        return res;
    }
}
