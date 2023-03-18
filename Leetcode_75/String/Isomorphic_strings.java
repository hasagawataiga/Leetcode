package Leetcode_75.String;
public class Isomorphic_strings {
    public boolean isIsomorphic(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        // Ignore the case the lengths of 2 strings are difference
        if (lengthS != lengthT){
            return false;
        }
        // Two arrays are used to store the time and position of char in strings
        int[] char1 = new int[128];
        int[] char2 = new int[128];
        for (int i = 0; i < lengthS; i++){
            // The value of char1['char'] would be increased whenever this char appeared in string
            // it increases += i + 1 instead of ++ because of:
            //  1. i for position, plus the position of this char to array to both store the time and position
            //  2. + 1 after i, to ignore the case char 'a'. Because the array value will be init with value 0 as default
            //      if traverse to the '0' char, the value of char1[s.charAt(i)] will be increase by 0, it breaks the rule that
            //          the array is used to store both appeared times and position
            char1[s.charAt(i)] += i + 1;
            char2[t.charAt(i)] += i + 1;
            // When the appeared times of char in 2 strings is difference, we can see obviously there is a string that its char appeared at least 1 more time than another.
            if (char1[s.charAt(i)] != char2[t.charAt(i)]){
                return false;
            }

        }
        return true;
    }
}
