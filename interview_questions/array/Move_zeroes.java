public class Move_zeroes {
    public void moveZeroes(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 0;
        int length = nums.length;
        while (pointer2 < length){
            if (nums[pointer2] != 0){
                swap(nums, pointer1++, pointer2);
            }
            pointer2++;
        }
        for (int i = pointer1; i < length; i++){
            nums[i] = 0;
        }
    }
    private void swap (int[] nums, int pointer1, int pointer2){
        int temp = nums[pointer1];
        nums[pointer1] = nums[pointer2];
        nums[pointer2] = temp;
    }
}

