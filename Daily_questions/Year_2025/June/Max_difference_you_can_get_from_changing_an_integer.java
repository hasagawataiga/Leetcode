public class Max_difference_you_can_get_from_changing_an_integer {
    class Solution {
        public int maxDiff(int num) {
            String str = String.valueOf(num);

            // Find min
            String minValue = findMin(str);

            // Find max
            String maxValue = findMax(str);

            return Integer.parseInt(maxValue) - Integer.parseInt(minValue);
        }

        private String findMax(String str) {
            if (str.charAt(0) != '9') {
                return str.replaceAll(str.charAt(0) + "", "9");
            }
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch != '9') {
                    return str.replaceAll(ch + "", "9");
                }
            }
            return str;
        }

        private String findMin(String str) {
            if (str.charAt(0) != '1') {
                return str = str.replaceAll(str.charAt(0) + "", "1");
            }
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch != '1' && ch != '0') {
                    return str = str.replaceAll(ch + "", "0");
                }
            }
            return str;
        }
    }
}