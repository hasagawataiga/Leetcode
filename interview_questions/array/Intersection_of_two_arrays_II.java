public class Intersection_of_two_arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] container = new int[1001];
        for (int num : nums1){
           container[num]++;
        }
        List<Integer> resList = new ArrayList<Integer>();
        for (int num : nums2){
            if (container[num] > 0){
                resList.add(num);
                container[num]--;
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
