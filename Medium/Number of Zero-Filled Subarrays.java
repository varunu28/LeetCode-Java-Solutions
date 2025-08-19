class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long runningCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                runningCount++;
            } else {
                runningCount = 0;
            }
            count += runningCount;
        }
        return count;
    }
}
