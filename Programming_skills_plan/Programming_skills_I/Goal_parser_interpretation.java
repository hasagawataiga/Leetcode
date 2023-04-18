package Programming_skills_plan.Programming_skills_I;

public class Goal_parser_interpretation {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++){
            char ch = command.charAt(i);
            if (ch == '('){
                i++;
                char next = command.charAt(i);
                if (next == ')'){
                    sb.append("o");
                } else {
                    sb.append("al");
                    i += 2;
                }
            } else {
                sb.append("G");
            }
        }
        return sb.toString();
    }
}
