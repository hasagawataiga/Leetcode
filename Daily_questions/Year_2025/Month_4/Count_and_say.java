public class Count_and_say {
    class Solution {
        public String countAndSay(int n) {
            String currentVal = "1";
    
            for (int i = 1; i < n; i++) {
                currentVal = countAndSayProcess(currentVal);
            }
    
            return currentVal;
        }
    
        private String countAndSayProcess(String numStr) {
            StringBuilder sb = new StringBuilder();
            int index = 0; 
            while (index < numStr.length()) {
                int count = 1;
                while (index + 1 < numStr.length() && numStr.charAt(index) == numStr.charAt(index + 1)) {
                    count++;
                    index++;
                }
                sb.append(count);
                sb.append(numStr.charAt(index));
                index++;
            }
    
            return sb.toString();
        }
    }
}
