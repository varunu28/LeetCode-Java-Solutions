class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return helper(nums, target, dp);
    }

    private int helper(int[] nums, int target, Integer[] dp) {
        if (dp[target] != null) {
            return dp[target];
        }
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int num : nums) {
            if (target >= num) {
                count += helper(nums, target - num, dp);
            }
        }
        return dp[target] = count;
    }
}
