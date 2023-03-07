package interview_questions.sorting_and_searching;

import java.util.Arrays;

public class Merge_sorted_arrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || m == 0){
            for (int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        // Merge 2 given arrays into a new array to implement the whole merge sorting algorithm
        int length = nums1.length;
        int j = 0;
        for (int i = m; i < length; i++){
            nums1[i] = nums2[j++];
        }
        mergeSort(nums1);
    }
    private void mergeSort(int[] nums){
        if (nums.length < 2){
            return;
        }
        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, nums);
    }
    private void merge (int[] left, int[]right, int[] nums){
        int leftIndex = 0;
        int rightIndex = 0;
        int numsIndex = 0;
        int leftLength = left.length;
        int rightLength = right.length;
        while (leftIndex < leftLength && rightIndex < rightLength){
            if (left[leftIndex] < right[rightIndex]){
                nums[numsIndex++] = left[leftIndex++];
            } else {
                nums[numsIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < leftLength){
            nums[numsIndex++] = left[leftIndex++];
        }
        while (rightIndex < rightLength){
            nums[numsIndex++] = right[rightIndex++];
        }
    }
}
