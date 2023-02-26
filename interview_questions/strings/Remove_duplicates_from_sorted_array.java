package interview_questions.strings;

public class Remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 0;
        if(nums.length < 2){
            return nums.length;
        }
        while(pointer2 < (nums.length-1)){
            pointer2++;
            if(nums[pointer2] > nums[pointer1]){
                pointer1++;
                // swap 2 elements
                int temp = nums[pointer1];
                nums[pointer1] = nums[pointer2];
                nums[pointer2] = temp;
            }
        }
        return pointer1 + 1;
    }
}
