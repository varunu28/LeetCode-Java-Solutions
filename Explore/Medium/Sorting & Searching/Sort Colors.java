class Solution {
    public void sortColors(int[] nums) {
        
        int n0 = -1;
        int n1 = -1;
        int n2 = -1;
        
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            }
            else if (nums[i] == 1) {
                nums[++n2] = 2;
                nums[++n1] = 1;
            }
            else {
                nums[++n2] = 2;
            }
        }
    }
}
