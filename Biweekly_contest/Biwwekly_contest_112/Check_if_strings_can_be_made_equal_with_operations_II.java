package Biweekly_contest.Biwwekly_contest_112;

public class Check_if_strings_can_be_made_equal_with_operations_II {
    public boolean canBeEqual(String s1, String s2) {
        char[] oddContainer = new char[27];
        char[] evenContainer = new char[27];
        for (int i = 0; i < s1.length(); i++){
            if (i % 2 == 0){
                evenContainer[s1.charAt(i) - 'a']++;
                evenContainer[s2.charAt(i) - 'a']--;
            } else {
                oddContainer[s1.charAt(i) - 'a']++;
                oddContainer[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < oddContainer.length; i++){
            if (oddContainer[i] != 0 || evenContainer[i] != 0){
                return false;
            }
        }
        return true;
    }
}
