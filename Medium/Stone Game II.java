class Solution {
    public int stoneGameII(int[] piles) {
        Integer[][][] dp = new Integer[2][piles.length + 1][piles.length + 1];
        return helper(piles, dp, 0, 0, 1);
    }
    
    private int helper(int[] piles, Integer[][][] dp, int p, int i, int m) {
        if (i == piles.length) {
            return 0;
        }
        if (dp[p][i][m] != null) {
            return dp[p][i][m];
        }
        int result = p == 1 ? 1000_000 : -1;
        int s = 0;
        for (int j = 1; j <= Math.min(2 * m, piles.length - i); j++) {
            s += piles[i + j - 1];
            if (p == 0) {
                result = Math.max(result, s + helper(piles, dp, 1, i + j, Math.max(m, j)));
            } else {
                result = Math.min(result, helper(piles, dp, 0, i + j, Math.max(m, j)));
            }
        }
        return dp[p][i][m] = result;
    }
}
