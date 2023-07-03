public class Buddy_strings {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length()){
            return false;
        }
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        int diffs = 0;
        int charsCount = 0;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) != goal.charAt(i)){
                diffs++;
            }
            chars1[s.charAt(i) - 'a']++;
            chars2[goal.charAt(i) - 'a']++;
        }
        for (int i = 0; i < chars1.length; i++){
            if (chars1[i] != chars2[i]){
                return false;
            }
            if (chars1[i] != 0){
                charsCount++;
            }
        }
        if (charsCount < n && diffs == 0){
            return true;
        }
        return diffs == 2 ? true : false;
    }
}
