package Contest.Contest339;

public class Find_the_longest_balanced_substring_of_a_bianry_string {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int length = s.length();
        int index = 0;
        int zeroes = 0;
        int ones = 0;
        boolean hasPreZeroes = false;
        while (index < length){
            int val = s.charAt(index) - '0';
            if (hasPreZeroes && val == 1){
                hasPreZeroes = false;
                ones++;
            } else if (hasPreZeroes && val == 0){
                hasPreZeroes = true;
                zeroes++;
            } else if (!hasPreZeroes && val == 1){
                hasPreZeroes = false;
                ones++;
            } else if (!hasPreZeroes && val == 0){
                hasPreZeroes = true;
                zeroes = 1;
                ones = 0;
            }
            index++;
            res = Math.max(res, Math.min(zeroes, ones) * 2);
        }
        return res;
    }
}
