package Leetcode_75.Sliding_window_two_pointer;

public class Container_with_most_water {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int preArea = 0;
        int max = 0;
        while (left < right){
            int area = (int) ((right - left) * Math.min(height[right], height[left]));
            max = Math.max(max, area);
            if (height[right] > height[left]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
