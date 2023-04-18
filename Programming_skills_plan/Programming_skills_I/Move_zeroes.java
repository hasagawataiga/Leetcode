package Programming_skills_plan.Programming_skills_I;


// Two pointers approach
public class Move_zeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
