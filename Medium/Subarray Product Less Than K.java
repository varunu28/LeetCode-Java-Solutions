class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int result = 0;
        while (end < n) {
            prod *= nums[end++];
            while (start < end && prod >= k) {
                prod /= nums[start++];
            }
            result += end - start;
        }
        return result;
    }
}
