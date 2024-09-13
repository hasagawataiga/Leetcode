public class XOR_queries_of_a_subarray {
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int length = arr.length;
            // int[][] dp = new int[length][length];
            // boolean[][] isCalculated = new boolean[length][length];
            int[] res = new int[queries.length];
            int[] prefix = new int[length + 1];
            prefix[0] = 0;
            for (int i = 1; i < length + 1; i++) {
                prefix[i] = prefix[i - 1] ^ arr[i - 1];
            }
            for (int i = 0; i < queries.length; i++) {
                int start = queries[i][0];
                int end = queries[i][1];
                res[i] = prefix[end + 1] ^ prefix[start];
            }
            return res;
        }
    }
}
