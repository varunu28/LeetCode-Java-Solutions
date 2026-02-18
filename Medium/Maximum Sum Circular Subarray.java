class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int globalMax = nums[0];
        int currMin = nums[0];
        int globalMin = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            currMax = Math.max(currMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, currMax);
            currMin = Math.min(currMin + nums[i], nums[i]);
            globalMin = Math.min(currMin, globalMin);
        }
        if (globalMax < 0) {
            return globalMax;
        }
        return Math.max(sum - globalMin, globalMax);
    }
}
