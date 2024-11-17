class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i <= n - 2 * k; i++) {
            if (isStrictlyIncreasing(nums, i, k) && isStrictlyIncreasing(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrictlyIncreasing(List<Integer> nums, int idx, int k) {
        for (int start = idx; start < idx + k - 1; start++) {
            if (nums.get(start) >= nums.get(start + 1)) {
                return false;
            }
        }
        return true;
    }
}
