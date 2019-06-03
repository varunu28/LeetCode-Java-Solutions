class Solution {
    public int dominantIndex(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int secMaxNum = Integer.MIN_VALUE;
        int maxIdx = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxNum) {
                secMaxNum = maxNum;
                maxNum = nums[i];
                maxIdx = i;
            }
            else if (nums[i] > secMaxNum) {
                secMaxNum = nums[i];
            }
        }
        
        return maxNum >= 2 * secMaxNum ? maxIdx : -1;
    }
}
