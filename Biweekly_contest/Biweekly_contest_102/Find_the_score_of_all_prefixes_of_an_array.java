package Biweekly_contest.Biweekly_contest_102;

public class Find_the_score_of_all_prefixes_of_an_array {
    public long[] findPrefixScore(int[] nums) {
        int length = nums.length;
        long max = nums[0];
        long[] convers = new long[length];
        convers[0] = nums[0] * 2;
        long[] prefixs = new long[length];
        prefixs[0] = convers[0];
        for (int i = 1; i < length; i++){
            max = Math.max(max, nums[i]);
            convers[i] = nums[i] + max;
            prefixs[i] = prefixs[i - 1] + convers[i];
        }
        return prefixs;
    }
}
