package interview_questions.sorting_and_searching;

public class Merge_sorted_arrays2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = nums1.length - 1;    // last == length of nums - 1
        // Sorting the nums1 backward from the last element
        //  by comparing the element at m position and n position in 2 given arrays
        //  move 1 backward step after put this element at the right place.
        while (m > 0 && n > 0){
            if (nums1[m - 1] < nums2[n - 1]){
                nums1[last--] = nums2[n-- - 1];
            } else {
                nums1[last--] = nums1[m-- - 1];
            }
        }
        // It should be 2 circumstances left (m > 0 || n > 0) after the while loop above
        // But in the case m > 0, it means all nums2's elements were put into the nums1,
        //  then the elements left in nums1 are at the right posistion, we don't need to touch it anymore.
        while (n > 0){
            nums1[last--] = nums2[n-- - 1];
        }
    }
}
