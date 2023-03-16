package Recursion.Memoization;

import java.util.Arrays;

public class Fibonacci_number {
    public int fib(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return fib(cache, n);
    }
    private int fib(int[] cache, int n){
        if (cache[n] != -1){
            return cache[n];
        }
        if (n == 0 || n == 1){
            cache[n] = n;
            return cache[n];
        }
        int val;
        val = fib(cache, n - 1) + fib(cache, n - 2);
        cache[n] = val;
        return val;
    }
}
