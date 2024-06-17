public class Sum_of_square_numbers {
    public boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int)Math.sqrt(c);
        while (start <= end) {
            int sum = start * start + end * end;
            if (sum == c) {
                return true;
            } else if (sum > c || sum < 0) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
