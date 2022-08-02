class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int numOfRows = matrix.length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    for (int j = 0; j < numOfRows; j++) {
      pq.add(new int[]{0, j, matrix[0][j]});
    }
    for (int i = 0; i < k - 1; i++) {
      int[] removed = pq.poll();
      if (removed[0] == numOfRows - 1) {
        continue;
      }
      pq.add(new int[]{removed[0] + 1, removed[1], matrix[removed[0] + 1][removed[1]]});
    }
    return pq.peek()[2];
  }
}
