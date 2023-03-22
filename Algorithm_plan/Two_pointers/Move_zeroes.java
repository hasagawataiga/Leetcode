package Algorithm_plan.Two_pointers;

public class Move_zeroes {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            int leftVal = numbers[left];
            int rightVal = numbers[right];
            int sum = leftVal + rightVal;
            int middleVal = numbers[middle];
            if (sum < target){
                if (middleVal + rightVal < target){
                    left = middle;
                }
                left++;
            } else if (sum > target){
                if (leftVal + middleVal > target){
                    right = middle;
                }
                right--;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}
