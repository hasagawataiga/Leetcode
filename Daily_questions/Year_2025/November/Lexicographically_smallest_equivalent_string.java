public class Lexicographically_smallest_equivalent_string {
    class Solution {
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            UnionFind unions = new UnionFind(26);
            for (int i = 0; i < s1.length(); i++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(i);
                unions.union(ch1 - 'a', ch2 - 'a');
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < baseStr.length(); i++) {
                char ch = baseStr.charAt(i);
                sb.append(unions.intToChar(unions.findParent(ch - 'a')));
            }

            return sb.toString();
        }

        class UnionFind {
            int[] parent;
            UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            private char intToChar(int x) {
                return (char)(x + 'a');
            }

            private int findParent(int x) {
                if (parent[x] != x) {
                    parent[x] = findParent(parent[x]);
                }

                return parent[x];
            }

            private void union(int a, int b) {
                int parentA = findParent(a);
                int parentB = findParent(b);

                if (parentA < parentB) {
                    parent[parentB] = parentA;
                } else {
                    parent[parentA] = parentB;
                }
            }
        }
    }
}
