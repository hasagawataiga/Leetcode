

public class Minimum_flips_to_make_a_or_b_equal_to_c{
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (c != 0 || b != 0 || a != 0){
            if ((c & 1) == 1){
                if ((a & 1) == 0 && (b & 1) == 0){
                    count++;
                }
            } else {
                count += (a & 1) + (b & 1);
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
            
        }
        return count;
    }
}