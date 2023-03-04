class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int minPosition = -1;
        int maxPosition = -1;
        int leftIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftIdx = i;
            }
            if (nums[i] == minK) {
                minPosition = i;
            }
            if (nums[i] == maxK) {
                maxPosition = i;
            }
            result += Math.max(0, Math.min(maxPosition, minPosition) - leftIdx);
        }
        return result;
    }
}
