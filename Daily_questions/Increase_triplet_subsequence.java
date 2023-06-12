public class Increase_triplet_subsequence {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return false;
        }
        // stores the max
        // stores the min
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++){
            prefix[i] = Math.min(prefix[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 1; i--){
            if (nums[i] < suffix[i + 1] && nums[i] > prefix[i - 1]){
                return true;
            }
            suffix[i] = Math.max(suffix[i + 1], nums[i]);
        }
        return false;
    }
}
