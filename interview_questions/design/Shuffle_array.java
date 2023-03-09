package interview_questions.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shuffle_array {
    private int[] nums;
    private List<Integer> list;
    public Shuffle_array(int[] nums) {
        this.nums = nums;
        this.list = new ArrayList<>();
        for (int num : nums){
            list.add(num);
        }
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
        Collections.shuffle(list);
        int length = list.size();
        int[] shuffledArray = new int[length];
        for (int i = 0; i < length; i++){
            shuffledArray[i] = list.get(i);
        }
        return shuffledArray;
    }
}
