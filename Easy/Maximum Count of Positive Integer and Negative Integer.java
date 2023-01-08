class Solution {
    public int maximumCount(int[] nums) {
        int positiveCount = 0;
        int negativeCount = 0;
        for (int num : nums) {
            positiveCount += num > 0 ? 1 : 0;
            negativeCount += num < 0 ? 1 : 0;
        }
        return Math.max(positiveCount, negativeCount);
    }
}
