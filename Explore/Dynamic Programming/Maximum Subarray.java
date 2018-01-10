class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        
        while (i<nums.length) {
            if (sum < 0) {
                sum = nums[i];
            }
            else {
                sum += nums[i];
            }
            
            max = Math.max(sum,max);
            i++;
        }
        
        return max;
    }
}
