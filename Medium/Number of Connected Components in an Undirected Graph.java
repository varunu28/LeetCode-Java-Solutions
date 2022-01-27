class Solution {
  public int countComponents(int n, int[][] edges) {
    DisjointSet disjointSet = new DisjointSet(n);
    for (int[] edge : edges) {
      disjointSet.union(edge[0], edge[1]);
    }
    Set<Integer> rootSet = new HashSet<>();
    for (int i = 0; i < n; i++) {
      rootSet.add(disjointSet.find(i));
    }
    return rootSet.size();
  }

  private static class DisjointSet {

    private final int[] root;
    private final int[] rank;

    public DisjointSet(int size) {
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
  }
}
