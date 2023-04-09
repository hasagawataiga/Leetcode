import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum_of_distances {
    public long[] distance(int[] nums) {
        long[] res = new long[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (map.containsKey(num)){
                map.get(num).add(i);
            } else {
                map.put(num, new ArrayList<>());
                map.get(num).add(i);
            }
        }
//         for (int i = 0; i < nums.length; i++){
            
//         }
        for (int i = 0; i < nums.length; i++){
            if (map.get(nums[i]).size() == 1){
                res[i] = 0;
            } else {
                res[i] = calc(map, i, nums[i]);                
            }
        }
        return res;
    }
    private long calc(Map<Integer, List<Integer>> map, int index, int val){
        long sum = 0;
        List<Integer> list = map.get(val);
        for (int i = 0; i < list.size(); i++){
           if (list.get(i) != index){
               sum += (long)Math.abs(index - list.get(i));
           }
        }
        return sum;
    }
}
