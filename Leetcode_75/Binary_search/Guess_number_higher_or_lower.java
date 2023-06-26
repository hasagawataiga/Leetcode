package Leetcode_75.Binary_search;

public class Guess_number_higher_or_lower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (guess(mid) == -1){
                right = mid - 1;
            } else if (guess(mid) == 1){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
    private int guess(int n){
        return 0;
    }
}
