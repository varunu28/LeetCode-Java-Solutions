class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            ans[i] = -1;
        }
        
        for (int i=0;i<nums.length;i++) {
            int j = i+1;
            while (true) {
                if (j == nums.length) {
                    j = 0;
                }
                if (j == i) break;
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
                j++;
            }
        }
        
        return ans;
    }
}
