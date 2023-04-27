package Top_interview_150;

public class Jump_game {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int index = 0;
        if (length == 1){
            return true;
        }
        int maxIndex = 0;
        boolean[] visited = new boolean[length];
        while (index < length - 1){
            int temp = index;
            if (index > maxIndex){
                return false;
            }
            if (visited[index]){
                index++;
                continue;
            }
            while (temp < length && !visited[temp]){
                visited[temp] = true;
                temp += nums[temp];
            }
            if (temp >= length - 1){
                return true;
            }
            maxIndex = Math.max(maxIndex, temp);
            index++;
        }
        return false;
    }
}
