class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long prefixSum = 0;
        long result = -1;
        for (int i = 0; i < n; i++) {
            if (i >= 2 && nums[i] < prefixSum) {
                result = nums[i] + prefixSum;
            }
            prefixSum += nums[i];
        }
        return result;
    }
}
