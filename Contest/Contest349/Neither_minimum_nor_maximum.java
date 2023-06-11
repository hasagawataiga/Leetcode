package Contest.Contest349;

public class Neither_minimum_nor_maximum {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            if (nums[i] != min && nums[i] != max){
                count = Math.min(count, nums[i]);
            }
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}
