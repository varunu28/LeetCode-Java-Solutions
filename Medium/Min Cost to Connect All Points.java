class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                int[] curr = {weight, i, j};
                edges.add(curr);
            }
        }
        Collections.sort(edges, Comparator.comparingInt(a -> a[0]));
        UnionFind unionFind = new UnionFind(n);
        int minCost = 0;
        int edgeUsedCount = 0;
        for (int i = 0; i < edges.size() && edgeUsedCount < n - 1; i++) {
            int nodeOne = edges.get(i)[1];
            int nodeTwo = edges.get(i)[2];
            int weight = edges.get(i)[0];
            if (unionFind.union(nodeOne, nodeTwo)) {
                minCost += weight;
                edgeUsedCount++;
            }
        }
        return minCost;
    }

    private static class UnionFind {
        private final int[] group;
        private final int[] rank;

        public UnionFind(int n) {
            this.group = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.group[i] = i;
            }
        }

        public int find(int node) {
            if (group[node] != node) {
                group[node] = find(group[node]);
            }
            return group[node];
        }

        public boolean union(int nodeOne, int nodeTwo) {
            int groupOne = find(nodeOne);
            int groupTwo = find(nodeTwo);
            if (groupOne == groupTwo) {
                return false;
            }
            if (rank[groupOne] > rank[groupTwo]) {
                group[groupTwo] = groupOne;
            } else if (rank[groupOne] < rank[groupTwo]) {
                group[groupOne] = groupTwo;
            } else {
                group[groupOne] = groupTwo;
                rank[groupTwo]++;
            }
            return true;
        }
    }
}
