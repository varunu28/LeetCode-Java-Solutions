class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int maxNum = -1;
        int secMaxNum = -1;
        int maxNumIdx = -1;
        int secMaxNumIdx = -1;
        
        int idx = 0;
        int n = nums.length;
        
        while (idx < n) {
            if (nums[idx] > maxNum) {
                secMaxNum = maxNum;
                secMaxNumIdx = maxNumIdx;
                
                maxNum = nums[idx];
                maxNumIdx = idx;
            }
            else if (nums[idx] <= maxNum && nums[idx] > secMaxNum) {
                secMaxNum = nums[idx];
                secMaxNumIdx = idx;
            }
            
            idx++;
        }
        
        if (maxNumIdx == -1 || secMaxNumIdx == -1) {
            return -1;
        }
        
        if (maxNum >= 2 * secMaxNum) {
            return maxNumIdx;
        }
        
        return -1;
    }
}
