import java.util.Comparator;
import java.util.PriorityQueue;

public class Last_stone_weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones){
            queue.add(stone);
        }
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (size > 1){
                int greater = queue.poll();
                int smaller = queue.poll();
                if (greater != smaller){
                    queue.add(greater - smaller);
                }
            } else if (size == 1){
                res = queue.poll();
                break;
            } else {
                break;
            }
        }
        return res;
    }
}
