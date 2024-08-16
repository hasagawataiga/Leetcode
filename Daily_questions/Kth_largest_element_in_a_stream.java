import java.util.Arrays;

public class Kth_largest_element_in_a_stream {
    class KthLargest {
    private int[] kthElements;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        kthElements = new int[k];
        if (nums.length < k) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                kthElements[i] = nums[i];
            }
            for (int i = nums.length; i < k; i++) {
                kthElements[i] = Integer.MIN_VALUE;
            }
        } else {
            Arrays.sort(nums);
            for (int i = 0; i < k; i++) {
                kthElements[i] = nums[nums.length - 1 - i];
            }
        }

    }
    
    public int add(int val) {
        if (val <= kthElements[k - 1]) {
            return kthElements[k - 1];
        }
        int stackVal = val;
        for (int i = 0; i < k; i++) {
            if (stackVal > kthElements[i]) {
                int temp = kthElements[i];
                kthElements[i] = stackVal;
                stackVal = temp;
            }
        }
        return kthElements[k - 1];
    }
}

}
