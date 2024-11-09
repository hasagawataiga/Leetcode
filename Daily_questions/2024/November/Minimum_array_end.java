import java.util.ArrayList;
import java.util.List;

public class Minimum_array_end {
    class Solution {
        public long minEnd(int n, int x) {
            int[] bits = new int[64];
            
            List<Integer> xOneBits = setBits(x);
            int index = 0;
            // Add 'x' bits to 'bits' array for the merging later
            for (int xOneBit : xOneBits) {
                bits[index++] = xOneBit;
            }

            List<Integer> nOneBits = setBits(n - 1);
            index = 0;
            // Merge 'n' to 'x'
            for (int nOneBit : nOneBits) {
                while (index < bits.length && bits[index] == 1) {
                    index++;
                }
                bits[index++] = nOneBit;
            }

            long res = 0;
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == 1) {
                    res += Math.pow(2, i);
                }
            }

            return res;
        }

        private List<Integer> setBits(int num) {
            List<Integer> setBits = new ArrayList<>();
            while (num != 0) {
                setBits.add(num & 1);
                num >>= 1;
            }

            return setBits;
        }
    }
}