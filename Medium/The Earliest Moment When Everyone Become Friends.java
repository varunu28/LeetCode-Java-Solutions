class Solution {
  public int earliestAcq(int[][] logs, int n) {
    Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
    DisjointSet disjointSet = new DisjointSet(n);
    for (int[] log : logs) {
      disjointSet.union(log[1], log[2]);
      if (disjointSet.unionCount == 1) {
        return log[0];
      }
    }
    return -1;
  }

  private static final class DisjointSet {

    private final int[] root;
    private final int[] rank;
    public int unionCount;

    public DisjointSet(int size) {
      this.root = new int[size];
      this.rank = new int[size];
      for (int i = 0; i < size; i++) {
        this.root[i] = i;
        this.rank[i] = 1;
      }
      this.unionCount = size;
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
        this.unionCount--;
      }
    }


    public int find(int node) {
      if (node == root[node]) {
        return node;
      }
      return root[node] = find(root[node]);
    }
  }
}
