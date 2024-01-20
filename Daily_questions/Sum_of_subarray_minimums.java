public class Sum_of_subarray_minimums {
    int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - 1;
            while (j >= i) {
                int minIndex = findMin(arr, i, j);
                sum += arr[minIndex] * (j - minIndex + 1);
                sum %= MOD;
                j = minIndex - 1;
            }
        }
        return sum;
    }
    private int findMin(int[] arr, int start, int end) {
        int min = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < min) {
                start = i;
                min = arr[i];
            }
        }
        return start;
    }
}
