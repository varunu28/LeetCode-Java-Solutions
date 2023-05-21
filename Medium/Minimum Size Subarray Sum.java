class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < nums.length) {
            currSum += nums[end++];
            while (start < end && currSum - nums[start] >= target) {
                currSum -= nums[start++];
            }
            if (currSum >= target) {
                minLength = Math.min(minLength, end - start);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
