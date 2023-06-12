public class Increase_triplet_subsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int val1 = Integer.MAX_VALUE;
        int val2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= val1) {
                val1 = num;
            } else if (num <= val2) {
                val2 = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
