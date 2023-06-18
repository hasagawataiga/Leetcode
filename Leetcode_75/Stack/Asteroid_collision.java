package Leetcode_75.Stack;

import java.util.Stack;

public class Asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++){
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        asteroids = new int[stack.size()];
        int i = 0;
        for (int num : stack){
            asteroids[i++] = num;
        }
        return asteroids;
    }
}
