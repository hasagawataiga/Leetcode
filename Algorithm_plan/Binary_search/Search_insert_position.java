package Algorithm_plan.Binary_search;

public class Search_insert_position {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] >= target){
            return left;
        } else if (nums[right] < target){
            return right + 1;
        } else if (nums[right] == target){
            return right;
        }
        int middle = 0;
        while (left <= right){
            middle = left + (right - left)/2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] > target){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        // In the case can not find the target in the array
        // The last middle is the nearest position to the target if it was in the array
        // If the nums[middle] > target, the middle should be replaced by the target
        // otherwise, the target should be placed right next to the middle
        if (nums[middle] > target){
            return middle;
        } else {
            return middle + 1;
        }
    }
}
