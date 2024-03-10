public class Intersection_of_two_arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<Integer> res = new ArrayList<>();
        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
                while (i < length1 && nums1[i] == nums1[i - 1]) {
                    i++;
                }
                while (j < length2 && nums2[j] == nums2[j - 1]) {
                    j++;
                }
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
