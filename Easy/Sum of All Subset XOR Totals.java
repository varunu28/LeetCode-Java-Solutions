class Solution {
    public int subsetXORSum(int[] nums) {
        return recurse(nums, 0, 0);
    }

    private int recurse(int[] nums, int idx, int currXor) {
        if (idx == nums.length) {
            return currXor;
        }
        int performXor = recurse(nums, idx + 1, currXor ^ nums[idx]);
        int notPerformXor = recurse(nums, idx + 1, currXor);
        return performXor + notPerformXor;
    }
}
