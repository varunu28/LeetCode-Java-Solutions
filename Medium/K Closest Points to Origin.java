class Solution {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      double diff =  Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]) - Math.sqrt(
          o2[0] * o2[0] + o2[1] * o2[1]);
      return diff < 0 ? -1 : (diff > 0 ? 1 : 0);
    });
    Collections.addAll(pq, points);
    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
      result[i] = pq.poll();
    }
    return result;
  }
}
