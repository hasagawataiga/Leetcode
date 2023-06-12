import java.util.ArrayList;
import java.util.List;

public class Summary_ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0){
            return ranges;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == end || nums[i] - 1 == end){
                end = nums[i];
                continue;
            } else {
                ranges.add(range(start, end));
                start = nums[i];
                end = nums[i];
            }
        }
        ranges.add(range(start, end));
        return ranges;
    }
    private String range(int start, int end){
        StringBuilder sb = new StringBuilder();
        if (start == end){
            sb.append(start);
        } else {
            sb.append(start);
            sb.append("->");
            sb.append(end);
        }
        return sb.toString();
    }
}
