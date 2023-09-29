class Solution {
    public boolean isMonotonic(int[] nums) {
        int idx = 0;
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        } 
        boolean increasing = idx + 1 < nums.length && nums[idx] < nums[idx + 1];
        while (idx + 1 < nums.length) {
            if (nums[idx] > nums[idx + 1] && increasing) {
                return false;
            }
            if (nums[idx] < nums[idx + 1] && !increasing) {
                return false;
            }
            idx++;
        }
        return true;
    }
}
