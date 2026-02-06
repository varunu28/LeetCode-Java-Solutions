class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            result = Math.max(result, Math.max(prefix, suffix));
        }
        return result;
    }
}
