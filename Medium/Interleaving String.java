class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    Boolean[][] dp = new Boolean[s1.length()][s2.length()];
    return isInterleaveHelper(s1, 0, s2, 0, s3, 0, dp);
  }
  
  private boolean isInterleaveHelper(String s1, int i1, String s2, int i2, String s3, int i3, Boolean[][] dp) {
    if (i1 == s1.length()) {
      return s2.substring(i2).equals(s3.substring(i3));
    }
    if (i2 == s2.length()) {
      return s1.substring(i1).equals(s3.substring(i3));
    }
    if (dp[i1][i2] != null) {
      return dp[i1][i2]; 
    }
    dp[i1][i2] = (s3.charAt(i3) == s1.charAt(i1) && isInterleaveHelper(s1, i1 + 1, s2, i2, s3, i3 + 1, dp)) || 
                 (s3.charAt(i3) == s2.charAt(i2) && isInterleaveHelper(s1, i1, s2, i2 + 1, s3, i3 + 1, dp));
    return dp[i1][i2];
  }
}
