package Programming_skills_plan.Programming_skills_I;

import java.util.HashSet;
import java.util.Set;

public class Happy_number {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int num = 0;
        while (n != 0){
            int lastDigit = n%10;
            num = num + (int)Math.pow(lastDigit, 2);
            n /= 10;
        }
        if (num == 1 || !set.add(num)){
            return true;
        } else if (num < 5){
            return false;
        }
        return isHappy(num);
    }
}
