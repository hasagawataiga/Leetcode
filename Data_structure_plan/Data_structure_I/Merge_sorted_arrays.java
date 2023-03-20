package Data_structure_plan.Data_structure_I;

public class Merge_sorted_arrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] dummy = nums1.clone();
        while (i < m && j < n){
            if (dummy[i] < nums2[j]){
                nums1[k++] = dummy[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m){
            nums1[k++] = dummy[i++];
        }
        while (j < n){
            nums1[k++] = nums2[j++];
        }
    }
}
