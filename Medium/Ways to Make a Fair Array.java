class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] oddPreSum = new int[n + 1];
        int[] evenPreSum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                oddPreSum[i + 1] = oddPreSum[i] + nums[i];
                evenPreSum[i + 1] = evenPreSum[i];
            } else {
                evenPreSum[i + 1] = evenPreSum[i] + nums[i];
                oddPreSum[i + 1] = oddPreSum[i];
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int oddSumPrev = oddPreSum[i - 1];
            int evenSumPrev = evenPreSum[i - 1];
            int oddSumAfter = evenPreSum[n] - evenPreSum[i];
            int evenSumAfter = oddPreSum[n] - oddPreSum[i];
            if (oddSumPrev + oddSumAfter == evenSumPrev + evenSumAfter) {
                result++;
            }
        }
        return result;
    }
}
