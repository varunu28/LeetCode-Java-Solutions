class Solution {
  public int countNegatives(int[][] grid) {
    int total = 0;
    int n = grid[0].length;
    for (int[] gr : grid) {
      int negInd = binarySearchHelper(gr, 0, n - 1);
      if (negInd != -1) {
        total += n - negInd;
      }
    }
    return total;
  }
  
  private int binarySearchHelper(int[] arr, int start, int end) {
    int idx = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (arr[mid] < 0) {
        idx = idx == -1 ? mid : Math.min(idx, mid);
        end = mid - 1;
      }
      if (arr[mid] >= 0) {
        start = mid + 1;
      }
    }
    return idx;
  }
}
