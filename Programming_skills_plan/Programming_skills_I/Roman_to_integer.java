package Programming_skills_plan.Programming_skills_I;

public class Roman_to_integer {
    public int romanToInt(String s) {
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (ch == 'M'){
                num += 1000;
            } else if (ch == 'D'){
                num += 500;
            } else if (ch == 'C'){
                if (i < n - 1){
                    char nextCh = s.charAt(i + 1);
                    if (nextCh == 'D'){
                        num += 400;
                        i++;
                    } else if (nextCh == 'M'){
                        num += 900;
                        i++;
                    } else {
                        num += 100;
                    }
                } else {
                    num += 100;
                }
            } else if (ch == 'L'){
                num += 50;
            } else if (ch == 'X'){
                if (i < n - 1){
                    char nextCh = s.charAt(i + 1);
                    if (nextCh == 'L'){
                        num += 40;
                        i++;
                    } else if (nextCh == 'C'){
                        num += 90;
                        i++;
                    } else {
                        num += 10;
                    }
                } else {
                    num += 10;
                }
            } else if (ch == 'V'){
                num += 5;
            } else if (ch == 'I'){
                if (i < n - 1){
                    char nextCh = s.charAt(i + 1);
                    if (nextCh == 'V'){
                        num += 4;
                        i++;
                    } else if (nextCh == 'X'){
                        num += 9;
                        i++;
                    } else {
                        num += 1;
                    }
                } else {
                    num += 1;
                }
            }
        }
        return num;
    }
}
