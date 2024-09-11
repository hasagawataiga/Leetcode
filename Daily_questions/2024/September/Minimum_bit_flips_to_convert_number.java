public class Minimum_bit_flips_to_convert_number {
    class Solution {
        public int minBitFlips(int start, int goal) {
            int xorRes = start ^ goal;
            return countOnes(xorRes);
        }
    
        private int countOnes(int num) {
            int count = 0;
            while (num != 0) {
                count += num % 2;
                num = num / 2;
            }
            return count;
        }
    }
}