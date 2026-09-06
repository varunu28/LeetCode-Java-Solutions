class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        Integer[][] dp = new Integer[m + 1][n + 1];
        return recurse(s, t, 0, 0, dp);
    }

    private int recurse(String s, String t, int i, int j, Integer[][] dp) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = recurse(s, t, i + 1, j + 1, dp) + recurse(s, t, i + 1, j, dp);
        } else {
            dp[i][j] = recurse(s, t, i + 1, j, dp);
        }
        return dp[i][j];
    }
}
