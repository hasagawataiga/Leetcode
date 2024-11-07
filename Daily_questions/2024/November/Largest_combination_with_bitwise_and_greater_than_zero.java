public class Largest_combination_with_bitwise_and_greater_than_zero {
    class Solution {
        public int largestCombination(int[] candidates) {
            int length = candidates.length;
            int[] existedBits = new int[32];
            int largestCombination = 0;
            
            for (int i = 0; i < length; i++) {
                List<Integer> candidateBits = setBits(candidates[i]);
                for (int candidateBit : candidateBits) {
                    existedBits[candidateBit]++;
                    largestCombination = Math.max(largestCombination, existedBits[candidateBit]);
                }
            }

            return largestCombination;
        }

        private List<Integer> setBits(int num) {
            List<Integer> bits = new ArrayList<>();
            int index = 0;

            while (num != 0) {
                if ((num & 1) == 1) {
                    bits.add(index);
                }
                num >>= 1;
                index++;   
            }

            return bits;
        }
    }
}