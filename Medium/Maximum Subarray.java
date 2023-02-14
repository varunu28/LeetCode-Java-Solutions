class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum += num;
            if (currSum < num) {
                currSum = num;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
