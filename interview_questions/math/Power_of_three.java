package interview_questions.math;

public class Power_of_three {
    public boolean isPowerOfThree(int n) {
        if (n == 0){
            return false;
        }
        // First check whether n is divided by three
        //  and keep dividing n to three multiple times until reaching the end (n != 0)
        //  after divding, if n == 1, it would be the power of three, and otherwise
        while (n%3 == 0){
            n /= 3;
        }
        return n == 1;
    }
}
