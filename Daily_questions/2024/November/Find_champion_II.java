public class Find_champion_II {
    class Solution {
        public int findChampion(int n, int[][] edges) {
            int[] container = new int[n];
            for (int i = 0; i < edges.length; i++) {
                container[edges[i][1]]++;
            }
            int count = 0;
            int res = -1;
            for (int i = 0; i < n; i++) {
                if (container[i] == 0) {
                    res = i;
                    count++;
                }
            }
            return count == 1 ? res : -1;
        }
    }
}