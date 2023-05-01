package Top_interview_150;


// Dp approach
public class Product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // int[] products = new int[n];
        int[] suffixs = new int[n];
        suffixs[n - 1] = 1;
        for (int i = n - 2; i >=0; i--){
            suffixs[i] = suffixs[i + 1] * nums[i + 1];
        }
        int prefix = 1;
        for (int i = 0; i < n; i++){
            suffixs[i] = prefix * suffixs[i];
            prefix *= nums[i];
        }
        return suffixs;
    }
}
