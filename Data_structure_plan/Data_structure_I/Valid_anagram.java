package Data_structure_plan.Data_structure_I;

public class Valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] count = new int[27];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int num : count){
            if (num != 0){
                return false;
            }
        }
        return true;
    }
}

