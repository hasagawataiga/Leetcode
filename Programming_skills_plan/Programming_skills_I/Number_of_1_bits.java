package Programming_skills_plan.Programming_skills_I;

public class Number_of_1_bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if ((n&1) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
