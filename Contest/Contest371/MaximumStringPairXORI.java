package Contest.Contest371;

public class MaximumStringPairXORI {
    public int maximumStrongPairXor(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    max = Math.max(max, x ^ y);
                }
            }
        }
        return max;
    }
}
