class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];
        int finalScore = score(stoneValue, 0, dp);
        return finalScore == 0 ? "Tie" : (finalScore > 0 ? "Alice" : "Bob");
    }

    private int score(int[] stoneValue, int idx, Integer[] dp) {
        if (idx >= stoneValue.length) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int takeOne = Integer.MIN_VALUE;
        int takeTwo = Integer.MIN_VALUE;
        int takeThree = Integer.MIN_VALUE;
        takeOne = stoneValue[idx] - score(stoneValue, idx + 1, dp);
        if (idx + 1 < stoneValue.length) {
            takeTwo = stoneValue[idx] + stoneValue[idx + 1] - score(stoneValue, idx + 2, dp);
        }
        if (idx + 2 < stoneValue.length) {
            takeThree = stoneValue[idx] + stoneValue[idx + 1] + stoneValue[idx + 2] - score(stoneValue, idx + 3, dp);
        }
        return dp[idx] = Math.max(takeOne, Math.max(takeTwo, takeThree));
    }
}
