import java.util.HashMap;
import java.util.Map;

public class Subarrays_with_k_different_integers {
    public static void main(String[] args){
        int[] nums = new int[] {1,2,1,2,3};
        int k = 2;
        int ans = subarraysWithKDistinct(nums, k);
        System.out.println(ans);
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> container = new HashMap<>();
        int first = 0;
        int second = 0;
        int length = nums.length;
        int uniques = 0;
        int count = 0;
        while (second < length) {
            container.put(nums[second], container.getOrDefault(nums[second], 0) + 1);
            if (container.get(nums[second]) == 1) {
                uniques++;
            }
            System.out.print(nums[first] + "-" + nums[second] + ", " + "\n");
            if (uniques == k) {
                count++;
                second++;
            } else if (uniques > k) {
                container.put(nums[first], container.get(nums[first]) - 1);
                if (container.get(nums[first]) == 0) {
                    uniques--;
                }
                first++;
            } else {
                second++;
            }
            // System.out.print(nums[first] + "-" + nums[second] + ", " + "\n");
        }        
        return count;
    }
}
