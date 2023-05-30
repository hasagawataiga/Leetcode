import java.util.ArrayList;
import java.util.List;

public class Design_hashset {
    class MyHashSet {
        List<Integer> container;
        public MyHashSet() {
            container = new ArrayList<>();
        }
        
        public void add(int key) {
            if (!container.contains(key)){
                container.add(key);
            }
        }
        
        public void remove(int key) {
            if (container.contains(key)){
                container.remove(Integer.valueOf(key));
            }
        }
        
        public boolean contains(int key) {
            return container.contains(key);
        }
    }
    
}
