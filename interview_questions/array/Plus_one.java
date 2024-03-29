package interview_questions.array;

public class Plus_one {
    public int[] plusOne(int[] digits) {
        int length = digits.length;        
        for (int i = length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }
}
