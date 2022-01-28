class Solution {
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    int n = s.length();
    DisjointSet disjointSet = new DisjointSet(n);
    for (List<Integer> pair : pairs) {
      disjointSet.union(pair.get(0), pair.get(1));
    }
    Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int root = disjointSet.find(i);
      map.computeIfAbsent(root, k -> new PriorityQueue<>()).offer(s.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append(map.get(disjointSet.find(i)).poll());
    }
    return sb.toString();
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
