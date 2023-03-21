package Algorithm_plan.Binary_search;

// Reverse the whole array
// Reverse the first k elements
// Reverse the entire elements (k -> length - 1)
public class Rotate_array {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0){
            return;
        }
        reverse(nums, 0, length - 1);
        reverse(nums, k, length - 1);
        reverse(nums, 0, k - 1);
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    private void reverse(int[] nums, int left, int right){
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
