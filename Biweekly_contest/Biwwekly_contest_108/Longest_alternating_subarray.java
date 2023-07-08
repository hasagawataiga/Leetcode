package Biweekly_contest.Biwwekly_contest_108;

public class Longest_alternating_subarray {
    public int alternatingSubarray(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0; i < n; i++){
            int j = i + 1;
            int diff = 1;
            while (j < n && nums[j] - diff == nums[j - 1]){
                diff = (int)(-1 * diff);
                max = Math.max(max, j - i + 1);
                j++;
            }
        }
        return max;
        // int left = 1;
        // // int diff = 1;
        // // int max = Integer.MIN_VALUE;
        // int n = nums.length;
        // if (n == 2){
        //     if (nums[0] + 1 == nums[1]){
        //         return 2;
        //     } else {
        //         return -1;
        //     }
        // }
        // int right = n;
        // while (left < right){
        //     int mid = left + (right - left) / 2;
        //     if (mid < 2){
        //         return -1;
        //     }
        //     if (isValid(nums, mid)){
        //         left = mid + 1;
        //     } else {
        //         right = mid - 1;
        //     }
        // }
        // return left;
    }
    private boolean isValid(int[] nums, int range){
        int left = 0;
        int right = 1;
        int diff = 1;
        while (right < nums.length){
            if (nums[right] - diff == nums[right - 1]){
                if (right - left + 1 == range){
                    return true;
                }
                right++;
                diff = (int)(-1 * diff);
            } else if (nums[right] + diff == nums[right - 1]){
                left = right - 1;
                right++;
            } else {
                left = right;
                right++;
            }
        }
        return false;
    }
}
