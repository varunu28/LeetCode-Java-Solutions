class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }
        long maxValue = -1;
        for (int i = 1; i < n - 1; i++) {
            long left = (long) maxLeft[i - 1];
            long right = (long) maxRight[i + 1];
            maxValue = Math.max(maxValue, (left - nums[i]) * right);
        }
        return maxValue == -1 ? 0 : maxValue;
    }
}
