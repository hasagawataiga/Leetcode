package Algorithm_plan.Binary_search;

public class Binary_search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
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
        return -1;
    }
}
