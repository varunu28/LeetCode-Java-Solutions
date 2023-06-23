class Solution {
    public int longestArithSeqLength(int[] nums) {
        int result = 0;
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[j] - nums[i];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                result = Math.max(result, dp[i].get(diff));
            }
        }
        return result;
    }
}
