class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        boolean[] result = new boolean[queries.length];
        for (int i = 0, j = 0; i < queries.length; i++) {
            int[] query = queries[i];
            while (j < edgeList.length && edgeList[j][2] < query[2]) {
                unionFind.union(edgeList[j][0], edgeList[j++][1]);
            }
            result[query[3]] = unionFind.find(query[0]) == unionFind.find(query[1]);
        }
        return result;
    }
    
    private static class UnionFind {
        private final int[] parent;
        
        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }
        
        public void union(int x, int y) {
            parent[find(x)] = parent[find(y)];
        }
    }
}
