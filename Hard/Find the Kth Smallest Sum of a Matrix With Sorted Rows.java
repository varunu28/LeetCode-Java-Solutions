class Solution {
  public int kthSmallest(int[][] mat, int k) {
    PriorityQueue<Integer> prevSum = new PriorityQueue<>(Collections.reverseOrder());
    prevSum.add(0);
    for (int[] row : mat) {
      PriorityQueue<Integer> nextSum = new PriorityQueue<>(Collections.reverseOrder());
      for (int sum : prevSum) {
        for (int c = 0; c < mat[0].length; c++) {
          nextSum.add(sum + row[c]);
          if (nextSum.size() > k) {
            nextSum.poll();
          }
        }
      }
      prevSum = nextSum;
    }
    return prevSum.poll();
  }
}
