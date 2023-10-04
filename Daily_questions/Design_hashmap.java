import java.util.ArrayList;
import java.util.List;

public class Design_hashmap{
    class MyHashMap {
        List<Integer> keys;
        List<Integer> values;
        public MyHashMap() {
            this.keys = new ArrayList<>();
            this.values = new ArrayList<>();
        }
        
        public void put(int key, int value) {
            if (keys.contains(Integer.valueOf(key))){
                values.set(keys.indexOf(Integer.valueOf(key)), value);
            } else {
                keys.add(key);
                values.add(value);
            }
        }
        
        public int get(int key) {
            int index = keys.indexOf(Integer.valueOf(key));
            return index != -1 ? values.get(index) : -1;
        }
        
        public void remove(int key) {
            int index = keys.indexOf(Integer.valueOf(key));
            if (index != -1){
                values.remove(index);
                keys.remove(Integer.valueOf(key));    
            } 
        }
    }
}