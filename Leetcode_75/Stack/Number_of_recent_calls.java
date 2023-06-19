package Leetcode_75.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_recent_calls{
    class RecentCounter {
        Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }
        
        public int ping(int t) {
            queue.add(t);
            int peekVal = queue.peek();
            while (peekVal < t - 3000){
                queue.poll();
                peekVal = queue.peek();
            }
            return queue.size();
        }
    }
}