package Contest.Contest384;

public class Number_of_subarray_that_match_a_pattern_I {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int m = nums.length;
        int n = pattern.length;
        int[] temp = new int[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                temp[i] = -1;
            } else if (nums[i] < nums[i + 1]) {
                temp[i] = 1;
            } else {
                temp[i] = 0;
            }
        }
        int count = 0;
        int gap = m - n;
        for (int i = 0; i < gap; i++) {
            if (temp[i] == pattern[0]) {
                boolean isEqual = true;
                for (int j = 0; j < n; j++) {
                    if (temp[i + j] != pattern[j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    count++;
                }
            }
        }
        return count;
    }
}
