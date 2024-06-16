import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        // Use 2 seperate queue
        // The first queue is stored the projects which have the capital requirement higher than the money in the pocket
        PriorityQueue<int[]> remainProjects = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // The feasible projects always have the possible capital so we use a single int value instead of an array like the remain projects
        //  which are needed to be check the capital whether is suitable or not
        PriorityQueue<Integer> pickedProjectProfits = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < profits.length; i++) {
            if (capitals[i] <= w) {
                pickedProjectProfits.offer(profits[i]);
            } else {
                remainProjects.offer(new int[]{capitals[i], profits[i]});
            }
        }
        while (k-- > 0) {
            while (!remainProjects.isEmpty() && remainProjects.peek()[0] <= w) {
                pickedProjectProfits.offer(remainProjects.poll()[1]);
            }
            if (!pickedProjectProfits.isEmpty()) {
                w += pickedProjectProfits.poll();
            } else {
                break;
            }
        }
        return w;
    }
}