class Solution {
  public int[] shortestToChar(String S, char C) {
    int[] ans = new int[S.length()];
    int prev = Integer.MIN_VALUE / 2;
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == C) {
        prev = i;
      }
      ans[i] = i - prev;
    }
    prev = Integer.MAX_VALUE / 2;
    for (int i = S.length() - 1; i >= 0; i--) {
      if (S.charAt(i) == C) {
        prev = i;
      }
      ans[i] = Math.min(ans[i], prev - i);
    }
    return ans;
  }
}
