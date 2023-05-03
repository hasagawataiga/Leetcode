import java.util.ArrayList;
import java.util.List;

public class Find_the_difference_of_two_arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] container = new int[2001];
        for (int num : nums1){
            container[num + 1000] = 1;
        }
        for (int num : nums2){
            if (container[num + 1000] == 1){
                container[num + 1000] = -1;
            } else if (container[num + 1000] == 0){
                container[num + 1000] = 2;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int i = 0; i < 2001; i++){
            if (container[i] == 1){
                res.get(0).add(i - 1000);
            } else if (container[i] == 2){
                res.get(1).add(i - 1000);
            }
        }
        return res;
    }
}
