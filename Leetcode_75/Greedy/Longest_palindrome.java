package Leetcode_75.Greedy;

public class Longest_palindrome {
    public int longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int[] count = new int[132];
        for (char ch : charArray){
            count[ch - 'A']++;
        }
        int res = 0;
        for (int num : count){
            if (num != 0 && num > 1){
                // Using num/2*2 instead of num because there is a case when the count of chars is odd
                // num/2*2 will take the even as result (3 -> 2, 5 -> 4)
                res += num / 2 * 2; 
            }
        }
        return s.length() - res == 0 ? res : res + 1;
    }
}
