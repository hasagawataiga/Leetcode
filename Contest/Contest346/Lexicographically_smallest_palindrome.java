package Contest.Contest346;

public class Lexicographically_smallest_palindrome {
    public String makeSmallestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder head = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        while (left < right){
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            if (leftCh == rightCh){
                head.append(leftCh);
                tail.append(leftCh);
            } else {
                if (leftCh - rightCh > 0){
                    head.append(rightCh);
                    tail.append(rightCh);
                } else {
                    head.append(leftCh);
                    tail.append(leftCh);
                }
            }
            left++;
            right--;
        }
        if (left == right){
            head.append(s.charAt(left));
        }
        head.append(tail.reverse());
        return head.toString();
    }
}
