import java.util.Stack;

public class Daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Pair> prevTemps = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!prevTemps.isEmpty() && prevTemps.peek().val < temperatures[i]) {
                Pair tempPair = prevTemps.pop();
                ans[tempPair.index] = i - tempPair.index;
            }      
            prevTemps.push(new Pair(temperatures[i], i));
        }
        return ans;
    }
    class Pair{
        int val;
        int index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
