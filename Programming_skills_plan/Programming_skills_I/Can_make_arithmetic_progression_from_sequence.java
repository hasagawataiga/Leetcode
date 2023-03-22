package Programming_skills_plan.Programming_skills_I;

import java.util.Arrays;

public class Can_make_arithmetic_progression_from_sequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int length = arr.length;
        if (length < 3){
            return true;
        }
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 0; i < length - 1; i++){
            if (arr[i + 1] - arr[i] != diff){
                return false;
            }
        }
        return true;
    }
}
