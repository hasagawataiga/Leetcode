import java.util.ArrayList;
import java.util.List;

public class Find_all_duplicates_in_an_array {
        public List<Integer> findDuplicates(int[] nums) {
        boolean[] isExisteds = new boolean[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (isExisteds[num]) {
                res.add(num);
            }
            isExisteds[num] = true;
        }
        return res;
    }
}
