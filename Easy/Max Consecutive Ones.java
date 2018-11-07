class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int maxOnes = Integer.MIN_VALUE;
        int temp = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                temp++;
            }
            else {
                maxOnes = Math.max(maxOnes, temp);
                temp = 0;
            }
            
            i++;
        }
        
        return Math.max(maxOnes, temp);
    }
}
