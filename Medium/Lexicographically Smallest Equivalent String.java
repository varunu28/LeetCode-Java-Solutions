class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind unionFind = new UnionFind(26);
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            unionFind.union(c1 - 'a', c2 - 'a');
        }
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append((char) (unionFind.find(c - 'a') + 'a'));
        }
        return result.toString();
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            parent[node] = find(parent[node]);
            return parent[node];
        }

        public void union(int nodeOne, int nodeTwo) {
            int parentOne = find(nodeOne);
            int parentTwo = find(nodeTwo);
            if (parentOne != parentTwo) {
                if (parentOne < parentTwo) {
                    parent[parentTwo] = parentOne;
                } else {
                    parent[parentOne] = parentTwo;
                }
            }
        }
    }
}
