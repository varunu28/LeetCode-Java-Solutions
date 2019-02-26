class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        
        int maxVal = 0;
        int res = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                    else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            
            if (dp[i] > maxVal) {
                maxVal = dp[i];
                res = count[i];
            }
            else if (dp[i] == maxVal) {
                res += count[i];
            }
        }
        
        return res;
    }
}
