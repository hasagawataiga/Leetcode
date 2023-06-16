package Leetcode_75.Hashmap;

public class Determine_if_two_strings_are_close {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()){
            return false;
        }
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (int i = 0; i < word1.length(); i++){
            chars1[word1.charAt(i) - 'a']++;
            chars2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < chars1.length; i++){
            if (chars1[i] == 0){
                continue;
            }
            if (chars2[i] == 0){
                return false;
            }
            for (int j = 0; j < chars2.length; j++){
                if (chars1[i] == chars2[j]){
                    chars1[i] = -1;
                    chars2[j] = -1;
                }
            }
            if (chars1[i] != -1){
                return false;
            }
        }
        return true;
    }
}
