class Solution {
    public long mostPoints(int[][] questions) {
        Long[] dp = new Long[questions.length];
        return helper(questions, 0, dp);
    }
    
    private long helper(int[][] questions, int idx, Long[] dp) {
        if (idx >= questions.length) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        return dp[idx] = Math.max(
            questions[idx][0] + helper(questions, idx + questions[idx][1] + 1, dp),
            helper(questions, idx + 1, dp)
        );
    }
}
