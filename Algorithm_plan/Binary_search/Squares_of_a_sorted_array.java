package Algorithm_plan.Binary_search;

public class Squares_of_a_sorted_array {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
