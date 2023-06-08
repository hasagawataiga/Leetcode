package Programming_skills_plan.Programming_skills_I;


public class Multiply_strings{
    public String multiply(String num1, String num2) {
        String res = "0";
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--){
            int num = num2.charAt(i) - '0';
            // if (num == 0){
            //     sb.append("0");
            //     continue;
            // }
            String product = multiplyString(num1, num);
            if (product.equals("0")){
                sb.append("0");
                continue;
            }
            product += sb.toString();
            res = plusString(product, res);
            sb.append("0");
        }
        return res;
    }
    private String plusString(String num1, String num2){
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int extra = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0){
            int num = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + extra;
            extra = num / 10;
            num %= 10;
            i--;
            j--;
            sb.append(num);
        }
        while (i >= 0){
            int num = num1.charAt(i) - '0' + extra;
            extra = num / 10;
            num = num % 10;
            i--;
            sb.append(num);
        }
        while (j >= 0){
            int num = num2.charAt(j) - '0' + extra;
            extra = num / 10;
            num = num % 10;
            j--;
            sb.append(num);
        }
        if (extra > 0){
            sb.append(extra);
        }
        return sb.reverse().toString();
    }
    private String multiplyString(String num1, int num2){
        if (num2 == 0){
            return "0";
        }
        int i = num1.length() - 1;
        int extra = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            int num = (num1.charAt(i) - '0') * num2 + extra;
            extra = num / 10;
            num %= 10;
            i--;
            sb.append(num);
        }
        if (extra > 0){
            sb.append(extra);
        }
        return sb.reverse().toString();
    }
}