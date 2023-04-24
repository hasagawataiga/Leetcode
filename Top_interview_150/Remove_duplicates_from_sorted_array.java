package Top_interview_150;

public class Remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int[] set = new int[201];
        int lo = 0;
        int hi = 0;
        while (hi < nums.length){
            if (set[nums[hi] + 100] == 0){
                set[nums[hi] + 100]++;
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
