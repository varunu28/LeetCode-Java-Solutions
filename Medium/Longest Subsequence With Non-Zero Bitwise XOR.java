class Solution {
    public int longestSubsequence(int[] nums) {
        boolean allZero = nums[0] == 0;
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                allZero = false;
            }
            xor = xor ^ nums[i];
        }
        if (xor != 0) {
            return nums.length;
        }
        return allZero ? 0 : nums.length - 1;
    }
}
