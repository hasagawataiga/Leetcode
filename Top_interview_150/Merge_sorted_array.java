package Top_interview_150;

public class Merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = nums1.length - 1;
        while (m > 0 && n > 0){
            if (nums1[m - 1] < nums2[n - 1]){
                nums1[last--] = nums2[n-- - 1];
            } else {
                nums1[last--] = nums1[m-- - 1];
            }
        }
        while (n > 0){
            nums1[last--] = nums2[n-- - 1];
        }
    }
}
