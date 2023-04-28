package Top_interview_150;


// Greedy approach
public class Jump_game_II {
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }
        
        return answer;
    }


    // BFS approach
    // public int jump(int[] nums) {
    //     if (nums.length == 1){
    //         return 0;
    //     }
    //     int left = 0;
    //     int right = 0;
    //     int furthest = 0;
    //     int step = 0;
    //     while (right < nums.length - 1){
    //         for (int i = left; i < right + 1; i++){
    //             furthest = Math.max(furthest, nums[i] + i);
    //         }
    //         step++;
    //         left = right + 1;
    //         right = furthest;
    //     }
    //     return step;
    // }
}
