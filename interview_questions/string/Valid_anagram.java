package interview_questions.string;

public class Valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;   
        }
        int[] container = new int[26];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++){
            container[sCharArray[i] - 'a']++;
            container[tCharArray[i] - 'a']--;
        }
        for (int i : container){
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
