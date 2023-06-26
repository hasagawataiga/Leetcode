public class Total_costs_to_hire_k_workers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> heapHead = new PriorityQueue<>();
        PriorityQueue<Integer> heapTail = new PriorityQueue<>();
        int n = costs.length;
        int i = -1;
        int j = n - 1;
        long total = 0;
        while (i < candidates - 1 && j >= n - k - 1){
            i++;
            heapHead.offer(costs[i]);
            if (j == i){
                break;
            }
            j--;
            heapTail.offer(costs[j]);
        }
        // System.out.println(heapHead.size() + "," + heapTail.size());
        while (!heapHead.isEmpty() && !heapTail.isEmpty() && k > 0){
            int head = heapHead.peek();
            int tail = heapTail.peek();
            if (head <= tail){
                total += heapHead.poll();
                if (i + 1 < j){
                    heapHead.offer(costs[++i]);
                }
            } else {
                total += heapTail.poll();
                if (j - 1 > i){
                    heapTail.offer(costs[--j]);
                }
            }
            System.out.println(total);
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
