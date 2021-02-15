class Solution {
  public int[] kWeakestRows(int[][] mat, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));
    for (int i = 0; i < mat.length; i++) {
      pq.add(new int[]{i, getNumberOfOnes(mat[i])});
    }
    int[] result = new int[k];
    for (int i = 0; i < result.length && !pq.isEmpty(); i++) {
      result[i] = pq.poll()[0];
    }
    return result;
  }

  private int getNumberOfOnes(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] == 0) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return end < 0 ? 0 : start;
  }
}
