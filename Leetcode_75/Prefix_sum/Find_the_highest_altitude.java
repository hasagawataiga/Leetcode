package Leetcode_75.Prefix_sum;

public class Find_the_highest_altitude {
    public int largestAltitude(int[] gain) {
        int prefix = 0;
        int max = 0;
        for (int num : gain){
            prefix += num;
            max = Math.max(max, prefix);
        }
        return max;
    }
}
