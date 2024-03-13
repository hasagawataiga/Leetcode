public class Find_the_pivot_integer {
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        int[] prefixSum = new int[n + 1];
        int[] suffixSum = new int[n + 1];
        suffixSum[n] = n;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + i;
            if (suffixSum[i] == prefixSum[i]) {
                return i;
            }
        }
        return -1;
    }
}