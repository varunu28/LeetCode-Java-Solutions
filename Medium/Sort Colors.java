class Solution {
    public void sortColors(int[] nums) {
        int idx1 = 0;
        int idx2 = nums.length - 1;
        int idx = 0;
        
        while (idx <= idx2) {
            if (nums[idx] == 0) {
                nums[idx] = nums[idx1];
                nums[idx1] = 0;
                idx1++;
            }
            if (nums[idx] == 2) {
                nums[idx] = nums[idx2];
                nums[idx2] = 2;
                idx2--;
                idx--;
            }
            
            idx++;
        }
    }
}
