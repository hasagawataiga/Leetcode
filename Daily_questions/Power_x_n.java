public class Power_x_n {
    public double myPow(double x, int n){
        return binaryExp(x, (long) n);
    }
    public double binaryExp(double x, long n) {
        // Base case
        if (n == 0){
            return 1;
        }
        // Ignore n < 0
        if (n < 0){
            return 1.0 / binaryExp(x, -1 * n);
        }
        // If n is odd, x^n = (x * x) ^ (n - 1) / 2, normal otherwise
        if (n % 2 == 1){
            return x * binaryExp(x * x, (n - 1) / 2);
        } else {
            return binaryExp(x * x, n / 2);
        }
    }
}
