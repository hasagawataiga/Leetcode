public class Product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        int[] suffixProduct = new int[nums.length];
        suffixProduct[nums.length - 1] = 1;
        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProduct[i] * suffixProduct[i];
        }
        return res;
    }
}
