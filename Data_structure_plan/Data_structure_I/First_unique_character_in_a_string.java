package Data_structure_plan.Data_structure_I;

public class First_unique_character_in_a_string {
    public int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++){
            int index = s.indexOf(ch);
            if (index != -1 && s.lastIndexOf(ch) == index){
                res = Math.min(res, index);
            }
        }
        return res < s.length()? res : -1;
    }
}
