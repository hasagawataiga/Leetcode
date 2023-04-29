package Biweekly_contest.Biweekly_contest_103;


// Easy
public class Maximum_sum_with_exactly_k_elements {
    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums){
            max = Math.max(max, num);
        }
        for (int i = 1; i <= k; i++){
            sum += max;
            max += 1;
        }
        return sum;
    }
}
