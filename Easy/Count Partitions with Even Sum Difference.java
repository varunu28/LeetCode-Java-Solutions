class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = nums[i];
            prefixSum[i] += i == 0 ? 0 : prefixSum[i - 1];
        }
        int partitions = 0;
        for (int i = 0; i < n - 1; i++) {
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[n - 1] - prefixSum[i];
            partitions += (rightSum - leftSum) % 2 == 0 ? 1 : 0;
        }
        return partitions;
    }
}
