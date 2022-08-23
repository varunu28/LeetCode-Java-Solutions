class Solution {
  public int countOdds(int low, int high) {
    return (high - low) / 2 + (low % 2 != 0 || high % 2 != 0 ? 1 : 0);
  }
}
