class Solution {
  public int[][] generateMatrix(int n) {
    int[][] ans = new int[n][n];
    int left = 0;
    int top = 0;
    int right = n -1;
    int down = n - 1;
    int count = 1;
    while (left <= right) {
      for (int j = left; j <= right; j ++) {
        ans[top][j] = count++;
      }
      top++;
      for (int i = top; i <= down; i ++) {
        ans[i][right] = count ++;
      }
      right--;
      for (int j = right; j >= left; j --) {
        ans[down][j] = count ++;
      }
      down--;
      for (int i = down; i >= top; i --) {
        ans[i][left] = count ++;
      }
      left++;
    }
    return ans;
  }
}
