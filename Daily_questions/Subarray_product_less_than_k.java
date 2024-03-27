public class Subarray_product_less_than_k {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if (product >= k) {
                    break;
                }
                res++;
            }
        }
        return res;
    }
}
