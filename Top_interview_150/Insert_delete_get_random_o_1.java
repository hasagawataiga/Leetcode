package Top_interview_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Insert_delete_get_random_o_1 {
    class RandomizedSet {
        List<Integer> list;
        public RandomizedSet() {
            list = new ArrayList<>();
        }
        
        public boolean insert(int val) {
            if (list.contains(val)){
                return false;
            } else {
                list.add(val);
                return true;
            }
        }
        
        public boolean remove(int val) {
            if (list.contains(val)){
                Integer valInt = Integer.valueOf(val);
                list.remove(valInt);
                return true;
            } else {
                return false;
            }
        }
        
        public int getRandom() {
            Random rd = new Random();
            int size = list.size();
            int index = rd.nextInt(size);
            return list.get(index);
        }
    }
}