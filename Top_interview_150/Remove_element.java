package Top_interview_150;

public class Remove_element {
    public int removeElement(int[] nums, int val) {
        int lo = 0;
        int hi = 0;
        while (hi < nums.length){
            if (nums[hi] != val){
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
