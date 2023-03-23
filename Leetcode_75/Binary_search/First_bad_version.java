package Leetcode_75.Binary_search;

public class First_bad_version {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
    // Dummy method - the proper method is hidden by Leetcode
    private boolean isBadVersion(int middle) {
        return false;
    }
}
