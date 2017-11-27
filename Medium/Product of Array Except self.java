class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];

        for (int i = 0, tmp = 1; i < nums.length; i++) {
            ans[i] = tmp;
            tmp *= nums[i];
        }
        
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            ans[i] *= tmp;
            tmp *= nums[i];
        }
        
        return ans;
        
    }
}
