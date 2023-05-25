package Programming_skills_plan.Programming_skills_I;

public class Pow_x_n {
    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0){
            return res;
        }
        long absN = Math.abs((long)n);
        while (absN > 0){
            if ((absN & 1) == 1){
                res *= x;
            }
            x *= x;
            absN >>= 1;
        }
        if (n > 0){
            return res;
        } else {
            return 1/res;
        }
    }
}
