package Data_structure_plan.Data_structure_I;

import java.util.HashMap;

public class Ransom_note {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> container = new HashMap<>();
        char[] noteChar = ransomNote.toCharArray();
        char[] magazineChar = magazine.toCharArray();
        int noteLength = noteChar.length;
        int magazineLength = magazineChar.length;
        if (noteLength > magazineLength){
            return false;
        }
        for (int i = 0; i < magazineLength; i++){
            if (i < noteLength){
                char ch = noteChar[i];
                if (container.putIfAbsent(ch, 1) != null){
                    container.replace(ch, container.get(ch) + 1);
                }
            }
            char ch2 = magazineChar[i];
            if (container.putIfAbsent(ch2, -1) != null){
                container.replace(ch2, container.get(ch2) - 1);
            }
        }
        for (int value : container.values()){
            if (value > 0){
                return false;
            }
        }
        return true;
    }
}
