public class Find_the_longest_substring {

    class Solution {
        public int findTheLongestSubstring(String s) {
            // Map to store the first occurrence of each state (bitmask)
            Map<Integer, Integer> stateToIndex = new HashMap<>();
            stateToIndex.put(0, -1);  // Base case: empty substring has even counts for all vowels
            
            int state = 0;  // Bitmask representing vowel parity
            int maxLength = 0;  // Result for the longest valid substring
            
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                
                // Update the state (bitmask) based on the current character
                state ^= convertVowelToBitmask(ch);
                
                // If we have seen this state before, calculate the length of the valid substring
                if (stateToIndex.containsKey(state)) {
                    maxLength = Math.max(maxLength, i - stateToIndex.get(state));
                } else {
                    // Store the first occurrence of this state
                    stateToIndex.put(state, i);
                }
            }
            
            return maxLength;
        }

        // Converts a vowel to its corresponding bitmask value
        private int convertVowelToBitmask(char ch) {
            switch (ch) {
                case 'a':
                    return 1 << 0;  // 00001
                case 'e':
                    return 1 << 1;  // 00010
                case 'i':
                    return 1 << 2;  // 00100
                case 'o':
                    return 1 << 3;  // 01000
                case 'u':
                    return 1 << 4;  // 10000
                default:
                    return 0;  // Non-vowel characters don't affect the bitmask
            }
        }
    }

}