class Solution {
  public String getSmallestString(int n, int k) {
    StringBuilder sb = new StringBuilder();
    while (k > 0) {
      int maxPossible = Math.min(k - n + 1, 26);
      sb.append((char) ('a' + maxPossible - 1));
      k -= maxPossible;
      n--;
    }
    return sb.reverse().toString();
  }
}
