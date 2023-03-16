package interview_questions.array;


import java.util.HashSet;
import java.util.Set;

class Contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> container = new HashSet<Integer>();
        for (int element : nums){
            if (!container.add(element)){
                return true;
            }
        }
        return false;
    }
}
