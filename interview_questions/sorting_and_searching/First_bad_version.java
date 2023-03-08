package interview_questions.sorting_and_searching;
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
    // Dummy class for prevent error in repository, just ignore it
    //  because LeetCode has created a class named isBadVersion for this question
    //  so I created it here
    private boolean isBadVersion(int middle) {
        return false;
    }
}