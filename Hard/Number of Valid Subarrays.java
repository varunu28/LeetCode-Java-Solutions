class Solution {
    int count = 0;
    public int validSubarrays(int[] nums) {
        helper(nums, 0, 0, -1);
        return count;
    }

    private void helper(int[] nums, int firstIdx, int idx, int left) {
        if (idx - firstIdx > 1 || idx > nums.length - 1) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (left == -1) {
                count++;
                helper(nums, i, i + 1, nums[i]);
            }
            else if (nums[i] < left) {
                return;
            }
            else {
                count++;
                helper(nums, firstIdx, i + 1, left);
            }
        }
    }
}
