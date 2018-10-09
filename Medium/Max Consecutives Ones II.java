class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;
        int fast = 0;
        int max = Integer.MIN_VALUE;
        boolean flipped = false;
        int zeroIndex = slow;
        
        while (fast < nums.length) {
            if (nums[fast] != 1) {
                if (!flipped) {
                    flipped = true;
                    zeroIndex = fast;
                }
                else {
                    max = Math.max(max, fast - slow);
                    slow = zeroIndex + 1;
                    flipped = false;
                    fast = zeroIndex;
                }
            }
            
            fast++;
        }
        
        return Math.max(max, fast-slow);
    }
}
