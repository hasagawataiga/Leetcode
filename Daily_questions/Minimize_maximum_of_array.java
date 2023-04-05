public class Minimize_maximum_of_array {
    public int minimizeArrayValue(int[] nums) {
        long prefixSum = 0;
        long answer = 0;
        // Iterate over nums, update prefix sum and answer.
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i) / (i + 1));
        }
        return (int)answer;
    }
}
