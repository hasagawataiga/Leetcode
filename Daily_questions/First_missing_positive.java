public class First_missing_positive {
    public int firstMissingPositive(int[] nums) {
        boolean[] existedNumbers = new boolean[nums.length];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                existedNumbers[num - 1] = true;
            }
        }
        for (int i = 0; i < existedNumbers.length; i++) {
            if (!existedNumbers[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
