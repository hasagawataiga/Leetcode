package Biweekly_contest.Contest_100;

import java.util.PriorityQueue;

public class Find_score_of_an_array_after_marking_all_elements {
    class Pair{
        int num;
        int index;
        Pair(int num, int index){
            this.num = num;
            this.index = index;
        }
    }
    // Use PriorityQueue to take the min value to ignore multitimes iterating over the array.
    public long findScore(int[] nums) {
        long score = 0;
        int length = nums.length;
        boolean[] isMarkeds = new boolean[length];
        // The lower value goes first
        // If there is a tie, the lower index goes first
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
            if (a.num != b.num) return a.num - b.num;
            else return a.index - b.index;
        });
        // Prefer use .offer than .add for performance
        for (int i = 0; i < length; i++) {
            pq.offer(new Pair(nums[i], i));
        }
        while (!pq.isEmpty()) {
            int currNum = pq.peek().num;
            int currIdx = pq.peek().index;
            pq.poll();
            if (isMarkeds[currIdx]) continue;
            score += currNum;
            isMarkeds[currIdx] = true;
            if (currIdx + 1 < length) isMarkeds[currIdx + 1] = true;
            if (currIdx - 1 >= 0) isMarkeds[currIdx - 1] = true; 
        }
        return score;
    }
}
