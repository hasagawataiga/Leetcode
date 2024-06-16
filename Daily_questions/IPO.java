import java.util.PriorityQueue;

public class IPO {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        PriorityQueue<int[]> remainProjects = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pickedProjects = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < profits.length; i++) {
            remainProjects.offer(new int[]{capitals[i], profits[i]});
        }
        while (k-- > 0) {
            while (!remainProjects.isEmpty() && remainProjects.peek()[0] <= w) {
                pickedProjects.offer(remainProjects.poll());
            }
            if (!pickedProjects.isEmpty()) {
                w += pickedProjects.poll()[1];
            } else {
                break;
            }
        }
        return w;
    }
}