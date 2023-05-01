package Top_interview_150;


// Dp approach
public class Product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        int[] prefixs = new int[n];
        prefixs[0] = 1;
        int[] suffixs = new int[n];
        suffixs[n - 1] = 1;
        for (int i = 1; i < n; i++){
            prefixs[i] = prefixs[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >=0; i--){
            suffixs[i] = suffixs[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++){
            products[i] = prefixs[i] * suffixs[i];
        }
        return products;
    }
}
