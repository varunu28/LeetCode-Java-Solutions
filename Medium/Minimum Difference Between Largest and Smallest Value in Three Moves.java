class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 4;
        while (left < 4) {
            minDiff = Math.min(minDiff, nums[right++] - nums[left++]);
        }
        return minDiff;
    }
}
