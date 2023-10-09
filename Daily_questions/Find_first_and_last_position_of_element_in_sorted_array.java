public class Find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStart(nums, target, 0, nums.length - 1);
        result[1] = findEnd(nums, target, 0, nums.length - 1);
        return result;
    }
    private int findStart(int[] nums, int target, int left, int right){
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }
    private int findEnd(int[] nums, int target, int left, int right){
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}
