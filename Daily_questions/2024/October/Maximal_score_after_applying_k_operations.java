public class Maximal_score_after_applying_k_operations{
    class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (int num : nums) {
                queue.offer(num);
            }
            long sum = 0;
            while (k-- > 0 && !queue.isEmpty()) {
                int curr = queue.poll();
                sum += curr;
                queue.offer((int)Math.ceil(curr * 1.0 / 3));
            }
            return sum;
        }
    }
}