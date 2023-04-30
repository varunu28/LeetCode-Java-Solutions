class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int requiredEdges = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                requiredEdges += (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]));
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                requiredEdges += alice.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                requiredEdges += bob.union(edge[1], edge[2]);
            }
        }
        if (alice.isConnected() && bob.isConnected()) {
            return edges.length - requiredEdges;
        }
        return -1;
    }
    
    private class UnionFind {
        private final int[] representatives;
        private final int[] componentSize;
        private int components;
        
        public UnionFind(int n) {
            this.representatives = new int[n + 1];
            this.componentSize = new int[n + 1];
            this.components = n;
            for (int i = 0; i <= n; i++) {
                componentSize[i] = 1;
                representatives[i] = i;
            }
        }
        
        public int find(int x) {
            if (representatives[x] == x) {
                return x;
            }
            return representatives[x] = find(representatives[x]);
        }
        
        public int union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return 0;
            }
            if (componentSize[x] > componentSize[y]) {
                componentSize[x] += componentSize[y];
                representatives[y] = x;
            } else {
                componentSize[y] += componentSize[x];
                representatives[x] = y;
            }
            components--;
            return 1;
        }
        
        public boolean isConnected() {
            return components == 1;
        }
    }
}
