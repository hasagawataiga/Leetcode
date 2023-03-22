package Data_structure_plan.Data_structure_I;

public class Intersection_of_two_arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        int[] inters = new int[1001];
        for (int num : nums1){
            count[num]++;
        }
        int index = 0;
        for (int num : nums2){
            if (count[num] > 0){
                inters[index++] = num;
                count[num]--;
            }
        }
        int[] res = new int[index];
        for (int i = 0; i < index; i++) {
            res[i] = inters[i];
        }
        return res;
    }
}
