import java.util.*;
class Solution {
    public int minimumOperations(int[] nums) {
        int length = nums.length;
        int count = 0;
        if(length == 0){
            return 0;
        }
        if(length == 1){
            if(nums[0] == 0){return 0;}
            else{return 1;}
        }
        Arrays.sort(nums);
        if(nums[length-1] == 0){return 0;}
        for(int i = 0; i < length-1; i++){
            if((i > 0) && (nums[i] == nums[i-1])){continue;}
            if(nums[i] != 0){count++;}            
        }
        if (nums[length-2] < nums[length-1]){count++;}
        return count++;
    }
}
