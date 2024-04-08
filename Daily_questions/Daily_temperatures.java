import java.util.Stack;

public class Daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> prevTemps = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!prevTemps.isEmpty() && temperatures[prevTemps.peek()] < temperatures[i]) {
                int index = prevTemps.pop();
                ans[index] = i - index;
            }      
            prevTemps.push(i);
        }
        return ans;
    }
}
