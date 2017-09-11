class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int c = 1;
        int maxL = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i-1] < nums[i]) {
                c++;
            }
            else {
                maxL = Math.max(c,maxL);
                c = 1;
            }
        }
        return Math.max(c,maxL);
    }
}
