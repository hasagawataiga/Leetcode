package Dynamic_programming_plan.Dynamic_programming_I;

public class Maximum_length_of_subarray_with_positive_product {
    public int getMaxLen(int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length){
            while (right < nums.length && nums[right] != 0){
                right++;
            }
            int product = product(nums, left, right);
            if (product < 0){
                while (nums[left] > 0){
                    product = (int)product / nums[left];
                    left++;
                }
                product = (int)product / nums[left];
                left++;
            }
            res = Math.max(res, right - left);
            right++;
            left = right;
        }
        return res;
    }
    private int product(int[] nums, int left, int right){
        int product = 0;
        for (int i = left; i < right; i++){
            product *= nums[i];
        }
        return product;
    }
}
