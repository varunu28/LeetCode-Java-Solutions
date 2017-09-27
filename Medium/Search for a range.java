class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == target) {
                ans[0] = i;
                ans[1] = i;
                for (int j=nums.length-1;j>=0;j--) {
                    if (nums[j] == target) {
                        ans[1] = j;
                        break;
                    } 
                }
                break;
            }
        }
        return ans;
    }
}
