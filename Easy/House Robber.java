class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return robImpl(nums, 0, dp);
    }
    
    private int robImpl(int[] nums, int start, int[] dp) {
        if (start > nums.length-1) {
            return 0;
        }
        
        if (dp[start] != -1) {
            return dp[start];
        }
        
        dp[start] = Math.max(nums[start] + robImpl(nums, start+2, dp), robImpl(nums, start+1, dp));
        
        return dp[start];
    }
}
