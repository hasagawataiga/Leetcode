package Dynamic_programming_plan.Dynamic_programming_I;


// Using Kadane's algorithm
// Approach:
//  using kadane's algorithm to find the maximum and minimum so far at the specific index
//  while both max and min?
//  Imagine that we reached a negative element in the past, it made the preProduct to a negative result (while it should be the maximum if ignore the "-")
//      to handle it, we store this value into minProduct and it will be positive while we reach another negative element again
//      compare the maxProduct (which ignore the previous negative element) with the current minProduct (now is positive) and store it into the maxProduct again.
//      compare the current maxProduct to the res
public class Maximum_product_subarray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            // Create two new variable represented the max and min Product
            //  because it will be overlaped eachother
            //  using 2 new representation variables to ignore the case that the value of one changed affect the followed formula of other
            int prevMax = maxProduct;
            int prevMin = minProduct;
            maxProduct = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
            minProduct = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));
            res = Math.max(res, maxProduct);
        }
        return res;
    }
}
