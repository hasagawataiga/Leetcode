package Contest.Contest367;

import java.util.Arrays;

public class Find_indices_with_index_and_value_difference_i {
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        for (int i = indexDifference; i <= nums.length; i++){
            int start = 0;
            int end = i;
            while (end < nums.length){
                if (Math.abs(nums[start] - nums[end]) >= valueDifference){
                    ans[0] = start;
                    ans[1] = end;
                }
                start++;
                end++;
            }
        }
        return ans;
    }
}
