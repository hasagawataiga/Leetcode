package Programming_skills_plan.Programming_skills_I;

public class To_lower_case {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()){
            if (ch <= 'Z' && ch >= 'A'){
                sb.append((char)(ch + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
