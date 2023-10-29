import java.util.ArrayList;
import java.util.List;

public class Find_the_k_or_of_an_array {
        public int findKOr(int[] nums, int k) {
        int[] bitCounts = new int[32];
        for (int num : nums){
            List<Integer> bits = findBits(num);
            for (int bit : bits){
                bitCounts[bit]++;
            }
        }
        int res = 0;
        for (int i = 0; i < bitCounts.length; i++){
            if (bitCounts[i] >= k){
                res += Math.pow(2, i);
            }
        }
        return res;
    }
    private List<Integer> findBits(int num){
        List<Integer> bits = new ArrayList<>();
        int index = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                bits.add(index);
            }
            num = num >> 1;
            index++;
        }
        return bits;
    }
}
