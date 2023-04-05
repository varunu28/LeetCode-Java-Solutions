class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefixSum = 0L;
        long result = 0L;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            result = Math.max(result, (prefixSum + i) / (i + 1));
        }
        return (int) result;
    }
}
