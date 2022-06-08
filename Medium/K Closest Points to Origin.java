class Solution {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> getDistance(o2) - getDistance(o1));
    for (int[] point : points) {
      pq.add(point);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    int[][] result = new int[pq.size()][2];
    for (int i = 0; i < result.length; i++) {
      result[i] = pq.poll();
    }
    return result;
  }

  private int getDistance(int[] point) {
    return (point[0] * point[0]) + (point[1] * point[1]);
  }
}
