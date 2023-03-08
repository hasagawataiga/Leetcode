package interview_questions.dynamic_programming;


// There is a algorithm with time complexity O(n) named Kadane's algorithm
// But I used here with "divide and conquer" algorithm O(n logn)
//  because it is perhaps more efficient in practical problem (due to the extra space and type input)
public class Maximum_subarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        return findMaxSubArray(nums, 0, nums.length - 1);
    }
    private int findMaxSubArray(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        // use left + (right - left)/2 instead of (left + right)/2
        //  to prevent overflow in the case the sum of right + left is out of range of Integer (>Integer.MAX_VALUE)
        int middle = left + (right - left)/2;
        // Find the max in both ways:
        //  -divide array into 2 sub-arrays and find those max
        //  -the max through middle index which included a part of the leftside and a part of the rightside
        // Compare 3 maxes to eachother to find the final max
        int maxLeft = findMaxSubArray(nums, left, middle);
        int maxRight = findMaxSubArray(nums, middle + 1, right);
        int maxThroughMiddle = findMaxThroughMiddle(nums, middle, left, right);
        return Math.max(Math.max(maxLeft, maxRight), maxThroughMiddle);
    }
    private int findMaxThroughMiddle(int[] nums, int middle, int left, int right){
        int sumLeft = 0;
        int maxLeft = nums[middle];
        for (int i = middle; i >= left; i--){
            sumLeft += nums[i];
            maxLeft = Math.max(maxLeft, sumLeft);
        }
        int sumRight = 0;
        int maxRight = nums[middle + 1];
        for (int i = middle + 1; i <= right; i++){
            sumRight += nums[i];
            maxRight = Math.max(maxRight, sumRight);
        }
        return maxLeft + maxRight;
    }
}
