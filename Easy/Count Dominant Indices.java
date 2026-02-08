class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int[] suffixSum = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = nums[i];
            suffixSum[i] += i == n - 1 ? 0 : suffixSum[i + 1];
        }
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            double average = ((double) suffixSum[i + 1]) / (n - i - 1);
            if (nums[i] > average) {
                count++;
            }
        }
        return count;
    }
}
