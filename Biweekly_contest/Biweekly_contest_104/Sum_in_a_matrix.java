package Biweekly_contest.Biweekly_contest_104;

public class Sum_in_a_matrix {
    public int matrixSum(int[][] nums) {
        int col = nums[0].length;
        int row = nums.length;
        int sum = 0;
        for (int i = 0; i < col; i++){
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < row; j++){
                max = Math.max(max, findMax(nums[j]));
            }
            sum += max;
        }
        return sum;
    }
    private int findMax(int[] nums){
        int max = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        nums[index] = -1;
        return max;
    }
}
