public class Minimum_equal_sum_of_two_arrays_after_replacing_zeros {
    long sum1 = 0;
    long sum2 = 0;
    long zeroCount1 = 0;
    long zeroCount2 = 0;
    public long minSum(int[] nums1, int[] nums2) {    
        prepare(nums1, nums2);
        long totalWithZero1 = sum1 + zeroCount1;
        long totalWithZero2 = sum2 + zeroCount2;
        // long diff = Math.abs(totalWithZero1 - totalWithZero2);
        if (totalWithZero1 < totalWithZero2) {
            if (zeroCount1 != 0) {
                return totalWithZero2;
            }
        } else if (totalWithZero1 > totalWithZero2) {
            if (zeroCount2 != 0) {
                return totalWithZero1;
            }
        } else {
            return totalWithZero1;
        }
        return -1;
    }
    private void prepare(int[] nums1, int[] nums2) {
        for (int num : nums1) {
            if (num == 0) {
                zeroCount1++;
            } else {
                sum1 += num;
            }
        }
        for (int num : nums2) {
            if (num == 0) {
                zeroCount2++;
            } else {
                sum2 += num;
            }
        }
    }
}
