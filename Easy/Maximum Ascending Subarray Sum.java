class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int idx = 0;
        int n = nums.length;
        while (idx < n) {
            int currSum = nums[idx++];
            while (idx < n && nums[idx] > nums[idx - 1]) {
                currSum += nums[idx++];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
