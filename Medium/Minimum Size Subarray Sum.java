class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        
        while (fast < n) {
            sum += nums[fast];
            
            if (sum >= s) {
                while (slow <= fast) {
                    minLen = Math.min(minLen, fast - slow + 1);
                    if (sum - nums[slow] >= s) {
                        sum -= nums[slow];
                        slow++;
                    }
                    else {
                        break;
                    }
                }   
            }
            
            fast++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
