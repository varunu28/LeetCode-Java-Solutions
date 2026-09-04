class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            int instabilityScore = leftMax - rightMin[i];
            if (instabilityScore <= k) {
                return i;
            }
        }
        return -1;
    }
}
