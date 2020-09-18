class Solution {
  Integer[][] dp;
  public int maxUncrossedLines(int[] A, int[] B) {
    dp = new Integer[A.length][B.length];
    return helper(A, 0, B, 0);
  } 
  
  private int helper(int[] A, int idxA, int[] B, int idxB) {
    if (idxA == A.length || idxB == B.length) {
      return 0;
    } 
    if (dp[idxA][idxB] != null) {
      return dp[idxA][idxB];
    }
    if (A[idxA] == B[idxB]) {
      dp[idxA][idxB] = 1 + helper(A, idxA + 1, B, idxB + 1);
    }
    else {
      dp[idxA][idxB] = Math.max(helper(A, idxA + 1, B, idxB), helper(A, idxA, B, idxB + 1));
    }
    return dp[idxA][idxB];
  }
}
