class Solution {
    public int longestSubarray(int[] nums) {
        int zeroIdx = -1;
        int windowSize = 0;
        int startIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                startIdx = zeroIdx + 1;
                zeroIdx = i;
            }
            windowSize = Math.max(windowSize, i - startIdx);
        }
        return windowSize;
    }
}
