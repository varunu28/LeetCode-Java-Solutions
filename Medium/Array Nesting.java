class Solution {
    public int arrayNesting(int[] nums) {
        int maxSize = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int k = i; nums[k] >= 0; count++) {
                int numsK = nums[k];
                nums[k] = -1;
                k = numsK;
            }
            maxSize = Math.max(maxSize, count);
        }
        
        return maxSize;
    }
}
