class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxSoFar = -1;
        int candidate = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if (i == candidate) {
                max = maxSoFar;
            }
            if (nums[i] < max - k) {
                candidate = i + 1;
            }
        }
        return candidate < nums.length ? candidate : -1;
    }
}
