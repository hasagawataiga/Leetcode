import java.util.HashMap;
import java.util.PriorityQueue;



// Use hashmap to store the times of every element
// Use Heap (priority queue) to take k most times appear
public class Top_k_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for (int num : map.keySet()){
            heap.offer(num);
            if (heap.size() > k){
                heap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}
