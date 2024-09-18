public class Largest_number {
    class Solution {
        public String largestNumber(int[] nums) {
            // Convert the integers to strings
            String[] numStrs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numStrs[i] = String.valueOf(nums[i]);
            }
            
            // Sort the strings based on the concatenated result of a + b vs b + a
            Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));
            
            // If the largest number is 0, return "0"
            if (numStrs[0].equals("0")) {
                return "0";
            }
            
            // Build the largest number
            StringBuilder sb = new StringBuilder();
            for (String numStr : numStrs) {
                sb.append(numStr);
            }
            
            return sb.toString();
        }
    }
}
