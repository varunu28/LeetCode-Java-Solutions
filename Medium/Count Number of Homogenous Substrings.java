class Solution {
  private final int MOD = 1000000007;
  public int countHomogenous(String s) {
    int count = 0;
    int start = 0;
    int end = 0;
    int n = s.length();
    while (end < n) {
      if (s.charAt(start) == s.charAt(end)) {
        count = (count + (end - start + 1)) % MOD;
        end++;
      } else {
        start++;
      }
    }
    return count;
  }
}
