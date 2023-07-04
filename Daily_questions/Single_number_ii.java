public class Single_number_ii {
    public int singleNumber(int[] nums) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < 32; ++i){
            sum = 0;
            for (int num : nums){
                int temp = num;
                sum += temp >> i & 1;
            }
            sum %= 3;
            if (sum != 0){
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}
