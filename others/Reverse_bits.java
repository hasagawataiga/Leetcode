package others;

public class Reverse_bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversedNumber = 0;
        if (n == 0){
            return 0;
        }
        int countBits = 0;
        // Move n 1 bit to the right until reaching the digit 1
        while ((n&1) == 0){
            n >>>= 1;
            countBits++;
        }
        // Take the last digit of n and add it into the right of reversedNumber
        //  by 2 steps:
        //  - move the reversedNumber 1 digit to the left
        //  - use the | (OR bitwise operator) to take the value of temp into the right of reversedNumber
        while (n != 0){
            int temp = n&1;
            n >>>= 1;
            reversedNumber <<= 1;
            reversedNumber |= temp;
            countBits++;
        }
        // Fill the digits left with value 0
        while (countBits++ < 32){
            reversedNumber <<= 1;
        }
        return reversedNumber;
    }
}
