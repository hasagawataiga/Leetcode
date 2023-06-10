public class Maximum_value_at_a_given_index_in_a_bounded_array {
    
    // Binary Search approach
    public int maxValue(int n, int index, int maxSum) {
        int hi = maxSum;
        int lo = 1;
        int max = 0;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (sum((long)index, (long)n, (long)mid) <= maxSum){
                lo = mid + 1;
                max = Math.max(max, mid);
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }
    private long sum(long index, long n, long val){
        long sumLeft = 0;
        // Use the formula of the of the natural numbers from a to b: (a + b)(a - b + 1) / 2
        if (val <= index){
            // a = 1, b = index
            sumLeft += val * (val + 1) / 2;
            // And the rest are "1"s
            sumLeft += index - val + 1;
        } else {
            // a = val, b = val - index
            sumLeft += (val + val - index) * (index + 1) / 2;
        }
        long sumRight = 0;
        if (val <= n - index){
            // a = val, b = 1
            sumRight += val * (val + 1) / 2;
            // And the rest are "1"s
            sumRight += n - index - val;
        } else {
            // a = val, b = val - n + index + 1
            sumRight += (val + val - n + index + 1) * (n - index) / 2;
        }
        return sumLeft + sumRight - val;
    }
}
