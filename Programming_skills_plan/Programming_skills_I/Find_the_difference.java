package Programming_skills_plan.Programming_skills_I;

public class Find_the_difference {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0){
            return t.charAt(0);
        }
        int[] alphabet = new int[26];
        for (char ch : s.toCharArray()){
            alphabet[ch - 'a']++;
        }
        for (char ch : t.toCharArray()){
            alphabet[ch - 'a']--;
            if (alphabet[ch - 'a'] == -1){
                return ch;
            }
        }
        return t.charAt(0);
    }
}
