package Algorithm_plan.Binary_search;

public class First_bad_version {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle;
        while (left < right){
            middle = (left + (right - left)/2);
            if (isBadVersion(middle)){
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
    private boolean isBadVersion(int n){
        return false;
    }
}
