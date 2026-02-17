class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        Boolean[][] memo = new Boolean[nums.length + 1][sum + 1];
        return recurse(nums, 0, sum, memo);
    }

    private boolean recurse(int[] nums, int idx, int sum, Boolean[][] memo) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || idx == nums.length) {
            return false;
        }
        if (memo[idx][sum] != null) {
            return memo[idx][sum];
        }
        return memo[idx][sum] = (recurse(nums, idx + 1, sum - nums[idx], memo) || recurse(nums, idx + 1, sum, memo));
    }
}
