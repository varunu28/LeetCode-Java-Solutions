class Solution {
    public boolean canSortArray(int[] nums) {
        int lastGroupHighest = 0;
        int highest = nums[0];
        boolean bitChange = false;
        for (int i = 1; i < nums.length; i++) {
            bitChange = Integer.bitCount(highest) != Integer.bitCount(nums[i]);
            if (bitChange) {
                lastGroupHighest = highest;
            }
            highest = Math.max(nums[i], highest);
            if (nums[i] < lastGroupHighest) {
                return false;
            }
        } 
        return true;
    }
}
