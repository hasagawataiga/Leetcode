import java.util.Arrays;

public class K_radius_subarray_averages {
    public int[] getAverages(int[] nums, int k) {
        long prefix = 0;
        int n = nums.length;
        if (n < 2 * k + 1){
            int[] res = new int[n];
            Arrays.fill(res, -1);
            return res;
        }
        int right = 0;
        int left = 0;
        int curr = 0;
        int range = 2 * k + 1;
        int[] res = new int[n];
        while (right < range){
            prefix += nums[right++];
        }
        while (curr < n){
            if (curr >= k && curr < n - k){
                res[curr++] = (int) (prefix / range);
                if (right < n){
                    prefix += nums[right++];
                }
                prefix -= nums[left++];
            } else {
                res[curr++] = -1;
            }
        }
        return res;
    }
}
