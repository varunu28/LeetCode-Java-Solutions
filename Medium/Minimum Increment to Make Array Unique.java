class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int increments = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                increments += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return increments;
    }
}
