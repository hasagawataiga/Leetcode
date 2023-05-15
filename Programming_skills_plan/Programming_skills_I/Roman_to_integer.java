package Programming_skills_plan.Programming_skills_I;

public class Roman_to_integer {
    public int romanToInt(String s) {
        int num = 0;
        int n = s.length();
        int prev = 0;
        int curr = 0;
        for (int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            switch(ch){
                case 'I':
                    curr = 1;
                    break;
                case 'V':
                    curr = 5;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'M':
                    curr = 1000;
                    break;
            }
            if (curr < prev){
                num -= curr;
            } else {
                num += curr;
            }
            prev = curr;
        }
        return num;
    }
}
