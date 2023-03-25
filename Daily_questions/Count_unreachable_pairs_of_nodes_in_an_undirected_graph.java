
public class Count_unreachable_pairs_of_nodes_in_an_undirected_graph {
    int[] parent;
    int[] rank;
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        for (int[] edge : edges){
            unionFind(edge[0], edge[1]);
        }
        long[] componentGroup = new long[n];
        for (int i = 0; i < n; i++){
            componentGroup[findParent(i)]++;
        }
        long unreachablePairs = 0;
        long remainNodes = n;
        for (int i = 0; i < n; i++){
            if (componentGroup[i] == 0){
                continue;
            }
            remainNodes -= componentGroup[i];
            unreachablePairs += componentGroup[i] * remainNodes;
        }
        return unreachablePairs;
    }
    private void unionFind(int a,int b){
        int aParent = findParent(a);
        int bParent = findParent(b);
        if (aParent == bParent){
            return;
        }
        if (rank[aParent] > rank[bParent]){
            parent[bParent] = aParent;
        } else if (rank[aParent] < rank[bParent]){
            parent[aParent] = bParent;
        } else {
            parent[bParent] = aParent;
            rank[aParent]++;
        }
        return;
    }
    private int findParent(int a){
        while(parent[a] != a){
            a = parent[parent[a]];
        }
        return a;
    }
}
