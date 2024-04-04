public class Maximum_nesting_depth_of_the_parentheses {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
