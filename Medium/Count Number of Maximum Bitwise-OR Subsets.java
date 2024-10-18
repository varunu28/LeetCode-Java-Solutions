class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxValue = 0;
        for (int num : nums) {
            maxValue |= num;
        }
        Integer[][] dp = new Integer[n][maxValue + 1];
        return countMaxOrSubsets(nums, 0, 0, maxValue, dp);
    }

    private int countMaxOrSubsets(int[] nums, int idx, int current, int maxValue, Integer[][] dp) {
        if (idx == nums.length) {
            return (current == maxValue) ? 1 : 0;
        }
        if (dp[idx][current] != null) {
            return dp[idx][current];
        }
        int countWithout = countMaxOrSubsets(nums, idx + 1, current, maxValue, dp);
        int countWith = countMaxOrSubsets(nums, idx + 1, current | nums[idx], maxValue, dp);
        return dp[idx][current] = countWith + countWithout;
    }
}
