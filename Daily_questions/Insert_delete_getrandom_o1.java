import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Insert_delete_getrandom_o1 {
class RandomizedSet {
    List<Integer> container;
    Set<Integer> set;
    public RandomizedSet() {
        container = new ArrayList<>();
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if (set.add(val)) {
            container.add(val);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean remove(int val) {
        if (set.remove(val)) {
            container.remove(Integer.valueOf(val));
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        Random rd = new Random();
        int index = rd.nextInt(container.size());
        return container.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
