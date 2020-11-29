class Solution {
  public int maximumWealth(int[][] accounts) {
    return Arrays.stream(accounts)
        .map(e -> Arrays.stream(e).sum())
        .max(Integer::compareTo)
        .orElse(0);
  }
}
