package Top_interview_150;

public class Remove_duplicates_from_sorted_array_II {
    int range = 1000;
    public int removeDuplicates(int[] nums) {
        int[] set = new int[2 * range + 1];
        int lo = 0;
        int hi = 0;
        while (hi < nums.length){
            if (set[nums[hi] + range] < 2){
                set[nums[hi] + range]++;
                swap(nums, lo, hi);
                lo++;
            }
            hi++;
        }
        return lo;
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
