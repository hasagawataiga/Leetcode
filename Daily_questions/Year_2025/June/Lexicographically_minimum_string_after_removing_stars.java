public class Lexicographically_minimum_string_after_removing_stars {
    class Solution {
        public String clearStars(String s) {
            char[] chArray = s.toCharArray();
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            for (int i = 0; i < chArray.length; i++) {
                if (chArray[i] == '*') {
                    Pair curr = queue.poll();
                    chArray[curr.index] = '.';
                    chArray[i] = '.';
                } else {
                    queue.add(new Pair(chArray[i], i));
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chArray.length; i++) {
                if (chArray[i] == '.') {
                    continue;
                }
                sb.append(chArray[i]);
            }

            return sb.toString();
        }

        class Pair implements Comparable<Pair>{
            char ch;
            int index;

            Pair(char ch, int index) {
                this.ch = ch;
                this.index= index;
            }

            @Override
            public int compareTo(Pair other) {
                if (this.ch == other.ch) {
                    return Integer.compare(other.index, this.index);
                } else {
                    return Character.compare(this.ch, other.ch);                
                }
            }
        }
    }
}