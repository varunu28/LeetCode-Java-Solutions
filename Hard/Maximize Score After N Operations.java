class Solution {
    public int maxScore(int[] nums) {
        int dpSize = 1 << nums.length;
        int[] dp = new int[dpSize];
        Arrays.fill(dp, -1);
        return backtrack(nums, 0, 0, dp);
    }
    
    private int backtrack(int[] nums, int mask, int pickCount, int[] dp) {
        if (2 * pickCount == nums.length) {
            return 0;
        }
        if (dp[mask] != -1) {
            return dp[mask];
        }
        int maxScore = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (((mask >> i) & 1) == 1 || ((mask >> j) & 1) == 1) {
                    continue;
                }
                int newMask = mask | (1 << i) | (1 << j);
                int curr = (pickCount + 1) * gcd(nums[i], nums[j]);
                int remaining = backtrack(nums, newMask, pickCount + 1, dp);
                maxScore = Math.max(maxScore, curr + remaining);
            }
        }
        return dp[mask] = maxScore;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
