class Solution {
    public int peakValleyDifference(int[] nums) {
        int peakSum = 0;
        int valleySum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peakSum += nums[i];
            }
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                valleySum += nums[i];
            }
        }
        return peakSum - valleySum;
    }
}
