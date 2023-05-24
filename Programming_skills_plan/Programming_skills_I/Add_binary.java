package Programming_skills_plan.Programming_skills_I;

public class Add_binary {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()){
            String temp = a;
            a = b;
            b = temp;
        }

        StringBuilder sb = new StringBuilder();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int i1 = aChars.length - 1;
        int i2 = bChars.length - 1;
        int extra = 0;
        while (i1 >= 0 && i2 >= 0){
            int digit1 = aChars[i1--] - '0';
            int digit2 = bChars[i2--] - '0';
            if (digit1 + digit2 + extra > 1){
                extra = 1;
                sb.append("0");
            } else if (digit1 + digit2 + extra > 0){
                extra = 0;
                sb.append("1");
            } else {
                extra = 0;
                sb.append("0");
            }
        }
        while (i1 >= 0){
            int digit = aChars[i1--] - '0';
            if (digit + extra > 1){
                extra = 1;
                sb.append("0");
            } else if (digit + extra > 0){
                extra = 0;
                sb.append("1");
            } else {
                extra = 0;
                sb.append("0");
            }
        }
        if (extra == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
