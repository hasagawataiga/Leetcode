public class Minimum_height_trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        List<Integer> ans = new ArrayList<>();
        int[] counts = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        // Remove the leaf by adding it into queue
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1) {
                queue.offer(i);
            }
        }
        // The node left to be the root (middle) of the tree
        // It would be less than or equal to 2 because in the case, we have at least 3 nodes left, the middle of those must the 'actually' middle node
        int removedNodes = 0;
        while (n - removedNodes > 2) {
            int size = queue.size();
            removedNodes += size;
            // Check all the nodes which have 1 connection and remove it from the tree by finding their neighbors,
            // subtract all the neighbors connections by 1 (because the nodes inside queue are removed)
            // then adding those neighbors to the queue again (if they have only 1 connection)
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                List<Integer> neighbors = map.get(temp);
                for (int neighbor : neighbors) {
                    counts[neighbor]--;
                    if (counts[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        // 1 or 2 nodes left are the roots of the tree
        for (int root : queue) {
            ans.add(root);
        }
        return ans;
    }
}
