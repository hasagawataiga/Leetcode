public class Sign_of_the_product_of_an_array {
    public int arraySign(int[] nums) {
        int negative = 0;
        for (int num : nums){
            if (num == 0){
                return 0;
            } else if (num < 0){
                negative++;
            }
        }
        if (negative > 0 && negative%2 == 1){
            return -1;
        }
        return 1;
    }
}
