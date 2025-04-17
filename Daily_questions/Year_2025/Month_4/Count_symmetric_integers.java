
public class Count_symmetric_integers {
    class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        while (low <= high) {
            if (checkSymmetric(low++)) {
                count++;
            }
        }

        return count;
    }

    private boolean checkSymmetric(int num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();

        if (length % 2 == 1) {
            return false;
        }
        
        int sumHead = 0;
        int sumTail = 0;
        for (int i = 0; i < length / 2; i++) {
            sumHead += numStr.charAt(i) - '0';
            sumTail += numStr.charAt(length - 1 - i) - '0';
        }

        if (sumHead == sumTail) {
            return true;
        }

        return false;
    }
}
}
