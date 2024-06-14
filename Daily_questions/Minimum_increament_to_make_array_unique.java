import java.util.Arrays;

public class Minimum_increament_to_make_array_unique {
        public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] + 1) {
                count += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }
}
