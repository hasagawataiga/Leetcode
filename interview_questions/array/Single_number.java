package interview_questions.array;

public class Single_number {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}


// Note:
// With the ^ operator: XOR
// 5 ^ 5 == 0, 
// 0101 ^ 0101 == 0000
// After adding all elements, element has two (even) copies will be cancelled each other.
// Hence, the result will be the number has odd copies.