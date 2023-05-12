


public class Plus_one{
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[0] == 9){
            int[] newRes = new int[n + 1];
            for (int i = 0; i < n; i++){
                newRes[i + 1] = digits[i];
            }
            plusOne(newRes, n, 1);
            if (newRes[0] == 1){
                return newRes;
            } else {
                int[] ignoreFirst = new int[n];
                for (int i = 0; i < n; i++){
                    ignoreFirst[i] = newRes[i + 1];
                }
                return ignoreFirst;
            }
            // return newRes;
        }
        plusOne(digits, n - 1, 1);
        return digits;
    }
    private void plusOne(int[] digits, int i, int previousOver){
        if (i < 0){
            return;
        }
        if (previousOver == 0){
            return;
        }
        int digit = digits[i] + previousOver;
        if (digit > 9){
            digit %= 10;
        } else {
            previousOver = 0;
        }
        digits[i] = digit;
        plusOne(digits, i - 1, previousOver);
    }
}