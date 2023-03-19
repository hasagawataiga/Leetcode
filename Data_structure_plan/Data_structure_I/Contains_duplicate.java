package Data_structure_plan.Data_structure_I;

import java.util.HashSet;
import java.util.Set;

public class Contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
