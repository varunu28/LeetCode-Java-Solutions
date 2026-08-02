class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n];
        return endScore(piles, 0, n - 1, dp) > 0;        
    }

    private int endScore(int[] piles, int left, int right, Integer[][] dp) {
        if (left == right) {
            return piles[left];
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        int takeLeft = piles[left] - endScore(piles, left + 1, right, dp);
        int takeRight = piles[right] - endScore(piles, left, right - 1, dp);
        return dp[left][right] = Math.max(takeLeft, takeRight);
    }
}
