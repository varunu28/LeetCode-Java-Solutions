class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWays(nums, 0, 0, S, dp);
    }
    
    private void calculateWaysDfs(int[] nums, int idx, int S) {
        if (idx == nums.length) {
            if (S == 0) {
                count++;   
            }
            return;
        }
        dfs(nums, idx + 1, S - nums[idx]);
        dfs(nums, idx + 1, S + nums[idx]);
    }
    
    private int calculateWaysDp(int[] nums, int idx, int sum, int S, int[][] dp) {
        if (idx == nums.length) {
            return sum == S ? 1 : 0;
        }
        if (dp[idx][sum + 1000] != Integer.MIN_VALUE) {
            return dp[idx][sum + 1000];
        }
        int add = calculateWaysDp(nums, idx + 1, sum + nums[idx], S, dp);
        int sub = calculateWaysDp(nums, idx + 1, sum - nums[idx], S, dp);
        dp[idx][sum + 1000] = add + sub;
        return dp[idx][sum + 1000];
    }
}
