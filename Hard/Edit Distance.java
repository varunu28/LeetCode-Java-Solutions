class Solution {
    public int minDistance(String s1, String s2) {
        return minDistanceHelperDP(s1, s2, s1.length(), s2.length());
    }
    
    private int minDistanceHelperDP(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i=0;i<=m;i++) {
            for (int j=0;j<=n;j++) {
                // First substring is empty
                if (i == 0) {
                    dp[i][j] = j;
                }
                // Second substring is empty
                else if (j == 0) {
                    dp[i][j] = i;
                }
                // If character are same, value is same as the previous dp array
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // If different, then 1 + min
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }
}
