public class Make_string_a_subsequence_using_cyclic_increaments {
    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            int i = 0;
            int j = 0;
            int length1 = str1.length();
            int length2 = str2.length();
            
            while (i < length1 && j < length2) {
                char ch1 = str1.charAt(i);
                char ch2 = str2.charAt(j);
                System.out.println((char)(ch1 + 1));
                if (ch1 == ch2 || increaseCharByOne(ch1) == ch2) {
                    j++;
                }
                i++;
            }
    
            return j == length2 ? true : false;
        }
    
        private char increaseCharByOne(char ch) {
            if (ch == 'z') {
                return 'a';
            }
    
            return (char)(ch + 1);
        }
    }
}