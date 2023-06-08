package Programming_skills_plan.Programming_skills_I;


public class Multiply_strings{
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if (num1.equals("1")){
            return num2;
        }
        if (num2.equals("1")){
            return num1;
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] num = new int[n1 + n2];
        StringBuilder sb = new StringBuilder();
        for (int i = n1 - 1; i >= 0; i--){
            for (int j = n2 - 1; j >= 0; j--){
                int val1 = num1.charAt(i) - '0';
                int val2 = num2.charAt(j) - '0';
                int product = val1 * val2 + num[i + j + 1];
                num[i + j + 1] = product % 10;
                num[i + j] += product / 10; 
            }
        }
        for (int i = 0; i < num.length; i++){
            if (num[i] == 0 && sb.isEmpty()){
                continue;
            }
            sb.append(num[i]);
        }
        return sb.toString();
    }
}