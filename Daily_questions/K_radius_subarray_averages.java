import java.util.Arrays;

public class K_radius_subarray_averages {
    public int[] getAverages(int[] nums, int k) {
        long prefix = 0;
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (n < 2 * k + 1){
            return res;
        }
        int right = 0;
        int left = 0;
        int range = 2 * k + 1;
        while (right < range){
            prefix += nums[right++];
        }
        int curr = k;
        res[curr++] = (int) (prefix / range);
        while (curr < n - k){
            if (right < n){
                prefix += nums[right++];
            }
            prefix -= nums[left++];
            res[curr++] = (int) (prefix / range);
        }
        return res;
    }
}
