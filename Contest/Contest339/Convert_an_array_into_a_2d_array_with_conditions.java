package Contest.Contest339;

import java.util.ArrayList;
import java.util.List;

public class Convert_an_array_into_a_2d_array_with_conditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] container = new int[201];
        for (int num : nums){
            container[num]++;
        }
        for (int i = 0; i < container.length;){
            if (container[i] != 0){
                List<Integer> temp = new ArrayList<>();
                for (int j = i; j < container.length; j++){
                    if (container[j] != 0){
                        temp.add(j);
                        container[j]--;
                    }
                }
                res.add(temp);
            } else {
                i++;
            }
        }
        return res;
    }
}
