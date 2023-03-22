package Programming_skills_plan.Programming_skills_I;


// Call the difference chars is count
// The count must be 1 of 2 values (0, 2)
// Use ch1 and ch2 to store the difference chars of stirngs
// Whenever 2 chars at a position are difference, check whether those difference chars are equal to the other position of difference chars
public class Check_if_one_string_swap_can_make_strings_equal {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int ch1 = -1;
        int ch2 = -1;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                count++;
                if (ch1 == -1){
                    ch1 = s1.charAt(i) - 'a';
                    ch2 = s2.charAt(i) - 'a';
                } else if (ch1 != s2.charAt(i) - 'a' || ch2 != s1.charAt(i) - 'a'){
                    return false;
                }
            }
        }
        if (count == 0 || count == 2){
            return true;
        } else {
            return false;
        }
    }
}
