package Contest.Contest337;

public class Number_of_even_and_odd_bits {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        boolean isEven = true;
        while(n != 0){
            int lastBit = n&1;
            if (!isEven && lastBit == 1){
                res[1]++;
            }
            if (isEven && lastBit == 1){
                res[0]++;
            }
            isEven = !isEven;
            n >>= 1;
        }
        return res;
    }
}
