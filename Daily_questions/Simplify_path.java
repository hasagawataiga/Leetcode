import java.util.Stack;

public class Simplify_path {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++){
            String str = strings[i];
            if (str.isEmpty()){
                continue;
            } else if (str.equals(".")){
                continue;
            } else if (str.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        String res = "";
        while (!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
