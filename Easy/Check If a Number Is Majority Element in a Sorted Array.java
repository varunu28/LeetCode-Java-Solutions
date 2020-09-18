class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }
        
        if (nums.length == 2) {
            return nums[0] == target && nums[1] == target;
        }
        
        return nums[nums.length / 2 - 1] == target && nums[nums.length / 2 + 1] == target;
    }
}
