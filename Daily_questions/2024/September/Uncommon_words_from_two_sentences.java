public class Uncommon_words_from_two_sentences {
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            List<String> res = new ArrayList<>();
            String[] words1 = s1.split(" ");
            String[] words2 = s2.split(" ");
            int index = 0;
            Map<String, Integer> map = new HashMap<>();
            while (index < words1.length && index < words2.length) {
                String word1 = words1[index];
                String word2 = words2[index++];
                // System.out.println(word1 + ", " + word2);
                updateMap(map, word1);
                updateMap(map, word2);
                // printMap(map);
            }
            while (index < words1.length) {
                String word = words1[index++];
                updateMap(map, word);
            }
            while (index < words2.length) {
                String word = words2[index++];
                updateMap(map, word);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    res.add(entry.getKey());
                }
            }
            return res.stream().toArray(String[]::new);
        }
    
        private void updateMap(Map<String, Integer> map, String word) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
    
        private void printMap(Map<String, Integer> map) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }
}