class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
            int start = Math.max(0, i - nums[i]);
            int subarraySum = prefixSum[i];
            if (start > 0) {
                subarraySum -= prefixSum[start - 1];
            }
            result += subarraySum;
        }
        return result;
    }
}
