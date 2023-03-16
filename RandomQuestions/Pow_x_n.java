package RandomQuestions;

public class Pow_x_n {
    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0){
            return res;
        }
        // Use Math.abs((long)) to ignore error when n out of range int;
        long absN = Math.abs((long)n);
        // Check absN whether even or odd.
        // If even, multiply res with squaring x and halving n.
        // If odd, multiply res with x and minus n by 1 as normal

        // (absN & 1) == 1 is True when the most right bit of absN is 1.
        //  it means that absN is even. Otherwise, (absN & 1) == 0 means absN is odd.
        while (absN > 0){
            if ((absN & 1) == 1){
                res *= x;
            }
            x *= x;
            // Delete the most right bit of absN by: absN >>= 1;
            absN >>= 1;
        }
        if (n > 0){
            return res;
        } else {
            return 1/res;
        }
    }
}
