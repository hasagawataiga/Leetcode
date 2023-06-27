package Leetcode_75.Binary_search;

public class Find_peak_element {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 2){
            if (nums[0] < nums[1]){
                return 1;
            } else {
                return 0;
            }
        }
        if (n == 1){
            return 0;
        }
        if (nums[0] > nums[1]){
            return 0;
        } else if (nums[n - 1] > nums[n - 2]){
            return n - 1;
        }
        int left = 0;
        int right = n;
        // Assume the array is sorted in ascending order
        //  then, nums[i - 1] <= nums[i] <= nums[i + 1]
        //  or, in descending order: nums[i - 1] >= nums[i] >= nums[i + 1]
        // But the question said that there is must has at least 1 peak, so I can convert the problem into this kind of:
        //  if nums[i] < nums[i - 1], there must be a peak on the left side (not descending order)
        //  if nums[i] < nums[i + 1], there must be a peak on the right side (not ascending order)
        // Ofc, we have to check whether the mid is a peak or not first.
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mid == 0){
                return nums[0] > nums[1] ? 0 : 1;
            }
            if (mid == n - 1){
                return nums[n - 1] > nums[n - 2] ? n - 1 : n - 2;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            } else if (nums[mid] < nums[mid - 1]){
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }
        }
        return left;
    }
}
