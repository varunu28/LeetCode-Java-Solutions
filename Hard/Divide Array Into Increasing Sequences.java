class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int maxCount = 1;
        int count = 1;
        int idx = 1;
        int n = nums.length;
        while (idx < n) {
            if (nums[idx] == nums[idx - 1]) {
                count++;
            }
            else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
            
            idx++;
        }
        
        maxCount = Math.max(maxCount, count);
        
        return nums.length >= maxCount * K;
    }
}
