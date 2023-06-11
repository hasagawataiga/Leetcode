package Contest.Contest349;

public class Lexicographically_smallest_string_after_substring_operation {
    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        if (n == 1){
            char ch = s.charAt(i);
            if (ch == 'a'){
                sb.append('z');
            } else {
                sb.append((char)(ch - 1));
            }
            return sb.toString();
        }
        boolean isChanged = false;
        while (i < n){
            char ch = s.charAt(i);
            if (ch == 'a'){
                sb.append(ch);
                i++;
            } else {
                break;
            }
        }
        while (i < n){
            char ch = s.charAt(i);
            if (ch > 'a' && ch <= 'z'){
                isChanged = true;
                sb.append((char)(ch - 1));
            } else {
                break;
            }
            i++;
        }
        while (i < n){
            sb.append(s.charAt(i));
            i++;
        }
        if (isChanged){
            return sb.toString();
        } else {
            sb.delete(n - 1, n);
            char ch = s.charAt(n - 1);
            if (ch == 'a'){
                sb.append('z');
            } else {
                sb.append((char)(ch - 1));
            }
            return sb.toString();
        }
    }
}
