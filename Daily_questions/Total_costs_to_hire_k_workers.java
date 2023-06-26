import java.util.PriorityQueue;

public class Total_costs_to_hire_k_workers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> heapHead = new PriorityQueue<>();
        PriorityQueue<Integer> heapTail = new PriorityQueue<>();
        int n = costs.length;
        int i = 0;
        int j = Math.max(n - candidates, candidates);
        long total = 0;
        for (; i < candidates; i++){
            heapHead.offer(costs[i]);
        }
        for (; j < n; j++){
            heapTail.offer(costs[j]);
        }
        j = n - candidates - 1;
        while (!heapHead.isEmpty() && !heapTail.isEmpty() && k > 0){
            int head = heapHead.peek();
            int tail = heapTail.peek();
            if (head <= tail){
                total += heapHead.poll();
                if (i <= j){
                    heapHead.offer(costs[i++]);
                }
            } else {
                total += heapTail.poll();
                if (j >= i){
                    heapTail.offer(costs[j--]);
                }
            }
            k--;
        }
        while (!heapHead.isEmpty() && k > 0){
            total += heapHead.poll();
            k--;
        }
        while (!heapTail.isEmpty() && k > 0){
            total += heapTail.poll();
            k--;
        }
        return total;
    }
}
