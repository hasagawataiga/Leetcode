


public class Monotonic_array{
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int gap = 0;
        if (n < 3){
            return true;
        }
        gap = nums[1] - nums[0];
        int preGap = gap;
        for (int i = 2; i < n; i++){
            gap = nums[i] - nums[i - 1];
            if (preGap == 0){
                preGap = gap;
            } else if (preGap < 0){
                if (gap > 0){
                    return false;
                }
            } else {
                if (gap < 0){
                    return false;
                }
            }
        }
        return true;
    }
}