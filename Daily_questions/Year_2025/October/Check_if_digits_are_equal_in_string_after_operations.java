public class Check_if_digits_are_equal_in_string_after_operations {
    class Solution {
        public boolean hasSameDigits(String s) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() != 2) {
                sb = new StringBuilder();
                for (int i = 1; i < s.length(); i++) {
                    sb.append(operation(s, i));
                }
                s = sb.toString();
            }

            return sb.charAt(0) == (sb.charAt(1));
        }

        private String operation(String str, int index) {
            char a = str.charAt(index);
            char b = str.charAt(index - 1);
            int numA = (int)a;
            int numB = (int)b;

            return String.valueOf((numA + numB) % 10);
        }
    }
}
