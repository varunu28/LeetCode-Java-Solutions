class Solution {
  public int fixedPoint(int[] A) {
    int start = 0;
    int end = A.length - 1;
    int minIdx = Integer.MAX_VALUE;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (A[mid] == mid) {
        minIdx = Math.min(minIdx, mid);
        end = mid - 1;
      }
      else if (A[mid] > mid) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
  }
}
