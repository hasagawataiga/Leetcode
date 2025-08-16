public class Maximum_69_number {
    class Solution {
        public int maximum69Number (int num) {
            String numStr = Integer.toString(num);
            int index = numStr.indexOf("6");
            if (index == -1) {
                return num;
            }

            int res = 0;
            for (int i = 0; i < numStr.length(); i++) {
                int curr = (int)(numStr.charAt(i) - '0');
                if (i == index) {
                    curr = 9;
                }
                res = res * 10 + curr;
            }

            return res;
        }
    }
}
