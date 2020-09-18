class Solution {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(calculateMove(nums, true), calculateMove(nums, false));
    }
    
    private int calculateMove(int[] nums, boolean isEven) {
        int count = 0;
        
        for (int i = (isEven ? 0 : 1); i < nums.length; i += 2) {
            int curr = 0;
            if (i + 1 < nums.length) {
                if (nums[i] >= nums[i + 1]) {
                    curr = nums[i] - nums[i + 1] + 1;
                }
            }
            
            if (i - 1 >= 0) {
                if (nums[i] >= nums[i - 1]) {
                    curr = Math.max(curr, nums[i] - nums[i - 1] + 1);
                }
            }
            
            count += curr;
        }
        
        return count;
    }
}
