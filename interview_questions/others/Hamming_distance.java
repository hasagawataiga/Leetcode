package interview_questions.others;

public class Hamming_distance {
    public int hammingDistance(int x, int y) {
        // Using Hamming distance algorithm
        // First, we use XOR bitwise operator to find out the number of difference digits between those 2 numbers
        // After that, use algorithm the same as "Number_of_1_bits" we have done before to solve this question
        int differenceDigits = x^y;
        int count = 0;
        while (differenceDigits != 0){
            count += differenceDigits&1;
            differenceDigits >>>= 1;
        }
        return count;
    }
}
