package Algorithm_plan.Binary_search;

public class Move_zeroes {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++){
            if (nums[i] != 0){
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        for (int i = pointer; i < length; i++){
            nums[i] = 0;
        }
    }
}
