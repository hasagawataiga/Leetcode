package Data_structure_plan.Data_structure_I;



// Approach: find the index of chars of ransomNote in magazine
//  if it exists, we will ignore it in the next indexOf called by formula count[ch - 'a'] = index + 1;
//      the next indexOf(ch) will start from the previous index of this char + 1
public class Ransom_note {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        int magazineLength = magazine.length();
        int ransomNoteLength = ransomNote.length();
        if (magazineLength < ransomNoteLength){
            return false;
        }
        for (int i = 0; i < ransomNoteLength; i++){
            char ch = ransomNote.charAt(i);
            int index = magazine.indexOf(ch, count[ch - 'a']);
            if (index == -1){
                return false;
            }
            count[ch - 'a'] = index + 1;
        }
        return true;
    }
}
