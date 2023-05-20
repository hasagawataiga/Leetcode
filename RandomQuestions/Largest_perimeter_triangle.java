

public class Largest_perimeter_triangle{
    public int largestPerimeter(int[] nums) {
        int perimeter = 0;
        int length = nums.length;
        swapMax(nums, length - 1);
        swapMax(nums, length - 2);
        for (int i = length - 1; i > 1; i--){
            swapMax(nums, i - 2);
            if (nums[i - 1] + nums[i - 2] > nums[i]){
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return perimeter;
    }
    private void swapMax(int[] nums, int index){
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i <= index; i++){
            if (max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        int temp = nums[index];
        nums[index] = nums[maxIndex];
        nums[maxIndex] = temp;
    }
}