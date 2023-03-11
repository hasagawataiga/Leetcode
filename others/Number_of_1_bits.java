package others;

public class Number_of_1_bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        // Using Hamming Weight algorithm
        // Compares the last digit of n to 1 via AND bitwise operator
        //  ******(0/1) & 0001 always return 0 or 1
        //  - if return 1 --> count++
        //  - if return 0 --> count = count (still)
        // After comparation, move n 1 bit to the right
        //  because n is unsigned value, we use ">>>" instead of ">>" to ignore the first digit (the digit represented the sign of number)
        while (n != 0){
            count += n&1;
            n >>>= 1;
        }
        return count;
    }
}
