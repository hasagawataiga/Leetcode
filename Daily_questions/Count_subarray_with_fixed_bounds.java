public class Count_subarray_with_fixed_bounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex = -1;
        int maxIndex = -1;
        int splitPoint = -1;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                splitPoint = i;
            }
            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            int start = Math.min(minIndex, maxIndex);
            if ((start - splitPoint) > 0) {
                count += start - splitPoint;
            }
        }
        return count;
    }
}
