import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum_of_distances {
    public long[] distance(int[] nums) {
        long[] res = new long[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0; // Variable to store the sum of absolute differences
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i] && j != i) {
                    sum += Math.abs(i - j); // Calculate the absolute difference
                }
            }
            res[i] = sum; // Store the sum in the result array
        }
        return res;
    }
}
