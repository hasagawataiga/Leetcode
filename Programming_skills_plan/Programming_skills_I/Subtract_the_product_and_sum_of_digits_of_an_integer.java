package Programming_skills_plan.Programming_skills_I;

public class Subtract_the_product_and_sum_of_digits_of_an_integer {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0){
            int lastDigit = n%10;
            sum += lastDigit;
            product *= lastDigit;
            n = n/10;
        }
        return product - sum;
    }
}
