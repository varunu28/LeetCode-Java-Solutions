class Solution {
    public int missingElement(int[] nums, int k) {
        int idx = 0;
        while (idx < nums.length - 1) {
            if (nums[idx] != nums[idx + 1] - 1) {
                int diff = nums[idx + 1] - nums[idx] - 1;
                if (diff >= k) {
                    int step = nums[idx] + 1;
                    while (k > 1) {
                        step++;
                        k--;
                    }
                    
                    return step;
                }
                else {
                    k -= diff;
                }
            }
            
            idx++;
        }
        
        return nums[nums.length - 1] + k;
    }
}
