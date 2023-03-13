package RandomQuestions;

public class Running_sum_of_1d_array {
    public int[] runningSum(int[] nums) {
        if (nums.length < 1){
            return null;
        }
        return sum(nums, 1);
    }
    private int[] sum(int[] nums, int index){
        if (index == nums.length){
            return nums;
        }
        nums[index] = nums[index] + nums[index-1];
        return sum(nums, ++index);
    }
}
