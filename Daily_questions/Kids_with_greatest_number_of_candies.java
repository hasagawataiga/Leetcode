import java.util.ArrayList;
import java.util.List;

public class Kids_with_greatest_number_of_candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> res = new ArrayList<>();
        for (int num : candies){
            max = Math.max(max, num);
        }
        for (int num : candies){
            if (num >= max - extraCandies){
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
