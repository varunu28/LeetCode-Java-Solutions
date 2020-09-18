class Solution {
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
      public int compare(Node n1, Node n2) {
        int c = n1.dist - n2.dist;
        if (c != 0) {
          return c;
        }
        c = n1.workIdx - n2.workIdx;
        return c != 0 ? c : n1.cycleIdx - n2.cycleIdx;
      }
    });
    for (int i = 0; i < workers.length; i++) {
      for (int j = 0; j < bikes.length; j++) {
        pq.add(new Node(getDist(workers[i], bikes[j]), i, j));
      }
    }
    int[] ans = new int[workers.length];
    boolean[] bikesTaken = new boolean[bikes.length];
    Arrays.fill(ans, Integer.MIN_VALUE);
    while (!pq.isEmpty()) {
      Node node = pq.remove();
      if (ans[node.workIdx] == Integer.MIN_VALUE && !bikesTaken[node.cycleIdx]) {
        ans[node.workIdx] = node.cycleIdx;
        bikesTaken[node.cycleIdx] = true;
      }
    }
    return ans;
  }
  
  private int getDist(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }
}

class Node {
  int dist;
  int workIdx;
  int cycleIdx;
  
  public Node(int dist, int workIdx, int cycleIdx) {
    this.dist = dist;
    this.workIdx = workIdx;
    this.cycleIdx = cycleIdx;
  }
}
