package Dynamic_programming_plan.Dynamic_programming_I;

public class Fibonacci_number {
    int[] nums = new int[30];
    public int fib(int n) {
        if (n == 1 || n == 0){
            nums[n] = n;
            return nums[n];
        }
        if (nums[n - 1] == 0){
            nums[n - 1] = fib(n - 1);
        }
        if (nums[n - 2] == 0){
            nums[n - 2] = fib(n - 2);
        }
        
        return nums[n - 1] + nums[n - 2];
    }
}
