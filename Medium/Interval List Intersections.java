class Solution {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> list = new ArrayList<>();
    int startA = 0;
    int startB = 0;
    while (startA < A.length && startB < B.length) {
      int intervalStart = Math.max(A[startA][0], B[startB][0]);
      int intervalEnd = Math.min(A[startA][1], B[startB][1]);
      if (intervalStart <= intervalEnd) {
        list.add(new int[]{intervalStart, intervalEnd});
      }
      if (A[startA][1] < B[startB][1]) {
        startA++;
      }
      else {
        startB++;
      }
    }
    int[][] ans = new int[list.size()][2];
    return list.toArray(ans);
  }
}
