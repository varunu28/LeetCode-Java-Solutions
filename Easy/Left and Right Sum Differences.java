class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int leftToRightSum = 0;
        for (int i = 0; i < n; i++) {
            leftToRightSum += nums[i];
        }
        int[] result = new int[n];
        int rightToLeftSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            leftToRightSum -= nums[i];
            result[i] = Math.abs(rightToLeftSum - leftToRightSum);
            rightToLeftSum += nums[i];
        }
        return result;
    }
}
