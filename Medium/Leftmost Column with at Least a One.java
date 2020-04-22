/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> dims = binaryMatrix.dimensions();
    int rows = dims.get(0);
    int cols = dims.get(1);
    int minIdx = Integer.MAX_VALUE;
    for (int i = 0; i < rows; i++) {
      int idx = binarySearch(binaryMatrix, i, 0, cols - 1);
      if (idx != -1) {
        minIdx = Math.min(minIdx, idx);
      }
    }
    return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
  }
  
  private int binarySearch(BinaryMatrix binaryMatrix, int row, int start, int end) {
    int minIdx = Integer.MAX_VALUE;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (binaryMatrix.get(row, mid) == 1) {
        minIdx = Math.min(minIdx, mid);
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
  }
}
