class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long currPrefixSum = 0;
        int prefixScore = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currPrefixSum += nums[i];
            if (currPrefixSum <= 0) {
                break;
            }
            prefixScore++;
        }
        return prefixScore;
    }
}
