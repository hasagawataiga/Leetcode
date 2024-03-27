public class Subarray_product_less_than_k {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        int res = 0;
        int first = 0;
        int second = 0;
        int product = 1;
        while (second < nums.length) {
            product *= nums[second];
            while (product >= k) {
                product /= nums[first];
                first++;
            }
            res += second - first + 1;
            second++;
        }
        return res;
    }
}
