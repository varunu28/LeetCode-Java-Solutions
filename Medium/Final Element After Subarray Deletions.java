class Solution {
    public int finalElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(nums[0], nums[n - 1]);
    }
}
