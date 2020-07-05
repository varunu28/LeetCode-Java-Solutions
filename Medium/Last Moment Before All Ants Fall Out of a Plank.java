class Solution {
  public int getLastMoment(int n, int[] left, int[] right) {
    int res = 0;
    for (int ant : left) {
      res = Math.max(res, ant);
    }
    for (int ant : right) {
      res = Math.max(res, n - ant);
    }
    return res;
  }
}
