class Solution {
  public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((x, y) -> x.cost - y.cost);
    UnionFind unionFind = new UnionFind(n);
    for (int i = 0; i < n; i++) {
      int[] coordinate = points[i];
      for (int j = i + 1; j < n; j++) {
        int[] secondCoordinate = points[j];
        int cost = Math.abs(coordinate[0] - secondCoordinate[0]) + Math.abs(coordinate[1] - secondCoordinate[1]);
        Edge edge = new Edge(i, j, cost);
        priorityQueue.add(edge);
      }
    }
    int minimumCost = 0;
    int totalEdges = n - 1;
    while (!priorityQueue.isEmpty() && totalEdges > 0) {
      Edge edge = priorityQueue.poll();
      if (!unionFind.connected(edge.pointOne, edge.pointTwo)) {
        unionFind.union(edge.pointOne, edge.pointTwo);
        minimumCost += edge.cost;
        totalEdges--;
      }
    }
    return minimumCost;
  }

  private static class Edge {
    int pointOne;
    int pointTwo;
    int cost;

    public Edge(int pointOne, int pointTwo, int cost) {
      this.pointOne = pointOne;
      this.pointTwo = pointTwo;
      this.cost = cost;
    }
  }

  private static class UnionFind {

    private final int[] root;
    private final int[] rank;

    public UnionFind(int size) {
      this.root = new int[size];
      this.rank = new int[size];
      for (int i = 0; i < size; i++) {
        this.root[i] = i;
        this.rank[i] = 1;
      }
    }

    public void union(int nodeOne, int nodeTwo) {
      int rootOne = find(nodeOne);
      int rootTwo = find(nodeTwo);
      if (rootOne != rootTwo) {
        if (this.rank[rootOne] > this.rank[rootTwo]) {
          this.root[rootTwo] = rootOne;
        } else if (this.rank[rootOne] < this.rank[rootTwo]) {
          this.root[rootOne] = rootTwo;
        } else {
          this.root[rootTwo] = rootOne;
          this.rank[rootOne]++;
        }
      }
    }

    public int find(int node) {
      if (node == root[node]) {
        return node;
      }
      return root[node] = find(root[node]);
    }

    public boolean connected(int nodeOne, int nodeTwo) {
      return find(nodeOne) == find(nodeTwo);
    }
  }
}
