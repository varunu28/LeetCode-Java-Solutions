class Solution {
  public int maxCoins(int[] piles) {
    Arrays.sort(piles);
    int n = piles.length;
    int maxCoinCount = 0;
    for (int i = n / 3; i < n; i += 2) {
      maxCoinCount += piles[i];
    }
    return maxCoinCount;
  }
}
