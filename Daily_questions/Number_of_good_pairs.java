

public class Number_of_good_pairs{
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            count += calculate(entry.getValue());
        }
        return count;
    }

    private int calculate(int n){
        return (int)(n * (n - 1) / 2);
    }
}