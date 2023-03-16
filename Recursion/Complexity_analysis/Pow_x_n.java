package Recursion.Complexity_analysis;

public class Pow_x_n {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        long absN = Math.abs((long)n);
        if (n > 0){
            return myPow(x, x, absN);
        } else {
            System.out.println(n);
            return 1/myPow(x, x, absN);
        }
    }
    private double myPow(double x, double res, long n){
        if (n == 1){
            return res;
        }
        // x^n by repeatedly squaring x and halving n if n is even
        // otherwise, do as normal
        if(n%2 == 1){
            res *= x;
            return myPow(x, res, n - 1);
        } else {
            res *= x;
            x *= x;
            return myPow(x, res, n/2);
        }
    }
}
