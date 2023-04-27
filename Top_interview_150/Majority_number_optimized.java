package Top_interview_150;


// Boyer - Moore Voting algorithm
public class Majority_number_optimized {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        int i = 1;
        while (i < nums.length){
            if (nums[i] != major){
                count--;
            } else {
                count++;
            }
            if (count == -1){
                major = nums[i];
                count = 1;
            }
            i++;
        }
        return major;
    }
}
