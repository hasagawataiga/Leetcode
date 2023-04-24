package Top_interview_150;

public class Majority_number {
    public int majorityElement(int[] nums) {
        int majNum = 0;
        int length = nums.length;
        for (int i = 0; i < 32; i++){
            int bit = 1 << i;
            int count = 0;
            for (int num : nums){
                if ((num & bit) != 0){
                    count++;
                }
            }

            if (count > length / 2){
                majNum |= bit;
            }
        }
        return majNum;
    }
}
