class Solution {
  public int minimumCost(int n, int[][] connections) {
    Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
    UnionFind unionFind = new UnionFind(n);
    int totalCost = 0;
    for (int[] connection : connections) {
      int nodeOne = connection[0] - 1;
      int nodeTwo = connection[1] - 1;
      if (!unionFind.isConnected(nodeOne, nodeTwo)) {
        totalCost += connection[2];
        unionFind.union(nodeOne, nodeTwo);
        n--;
      }
    }
    return n == 1 ? totalCost : -1;
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

    public boolean isConnected(int nodeOne, int nodeTwo) {
      return find(nodeOne) == find(nodeTwo);
    }
  }
}
