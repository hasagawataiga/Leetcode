package Contest.Contest348;

public class Semi_ordered_permutation {
    public int semiOrderedPermutation(int[] nums) {
        int firstIndex = 0;
        int lastIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                firstIndex = i;
            }
            if (nums[i] == n){
                lastIndex = i;
            }
        }
        int count = 0;
        count = firstIndex + n - 1 - lastIndex;
        return firstIndex > lastIndex ? count - 1 : count;
    }
}
