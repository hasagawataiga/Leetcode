import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number_of_equivalent_domino_pairs {
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            Map<Domino, Integer> pairs = new HashMap<>();
            int count = 0;
            for (int i = 0; i < dominoes.length; i++) {
                Domino curr = new Domino(dominoes[i][0], dominoes[i][1]);
                if (pairs.containsKey(curr)) {
                    pairs.put(curr, pairs.get(curr) + 1);
                    // System.out.println(i + " Found");
                    // if (pairs.get(curr) == 2) {
                    //     count++;
                    //     System.out.println("Counted");
                    // }
                } else {
                    pairs.put(curr, 1);
                }
    
            }
    
            for (Map.Entry<Domino, Integer> entry : pairs.entrySet()) {
                if (entry.getValue() == 1) {
                    continue;
                }
    
                int val = entry.getValue();
                int combinations = (int) (val * (val - 1) / 2);
                count += combinations;
            }
    
            return count;
        }
    
        class Domino {
            int a;
            int b;
            Domino(int a, int b) {
                this.a = a;
                this.b = b;
            }
    
            @Override
            public boolean equals(Object object) {
                if (object == this) {
                    return true;
                }
        
                if (!(object instanceof Domino)) {
                    return false;
                }
                
    
                Domino other = (Domino) object;
    
                return (a == other.a && b == other.b) || (a == other.b && b == other.a);
            }
    
            @Override
            public int hashCode() {
                int min = Math.min(a, b);
                int max = Math.max(a, b);
                return Objects.hash(min, max);
            }
        }
    }
}
