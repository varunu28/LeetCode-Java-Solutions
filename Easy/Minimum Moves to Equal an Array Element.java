class Solution {
    public int minMoves(int[] nums) {
        int numOfMoves = 0;
        int minNum = getMin(nums);
        
        for (int i=0;i<nums.length;i++) {
            numOfMoves += nums[i]-minNum;
        }
        
        return numOfMoves;
    }
    
    public int getMin(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        
        for (int i=0;i<arr.length;i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }
}
