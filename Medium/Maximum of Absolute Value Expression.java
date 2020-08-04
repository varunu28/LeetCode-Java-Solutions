class Solution {
  public int maxAbsValExpr(int[] arr1, int[] arr2) {
    int res = 0;
    int n = arr1.length;
    int[] dirs = {-1,1};
    for (int dir1 : dirs) {
      for (int dir2 : dirs) {
        int closest = dir1 * arr1[0] + dir2 * arr2[0] + 0;
        for (int i = 1; i < n; ++i) {
          int cur = dir1 * arr1[i] + dir2 * arr2[i] + i;
          res = Math.max(res, cur - closest);
          closest = Math.min(closest, cur);
        }
      }
    }
    return res;
  }
}
