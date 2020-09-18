class Solution {
  public int numWays(int n, int k) {
    int[] ways = new int[Math.max(n + 1, 3)];
    ways[0] = 0;
    ways[1] = k;
    ways[2] = k * k;
    for (int i = 3; i <= n; i++) {
      ways[i] = (ways[i - 1] * (k - 1)) + (ways[i - 2] * (k - 1));
    }
    return ways[n];
  }
}
