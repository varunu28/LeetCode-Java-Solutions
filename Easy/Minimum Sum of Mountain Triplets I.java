class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] smallestRight = new int[n];
        smallestRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            smallestRight[i] = Math.min(smallestRight[i + 1], nums[i]);
        }
        int smallestLeft = nums[0];
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (smallestLeft < nums[i] && smallestRight[i] < nums[i]) {
                result = Math.min(result, nums[i] + smallestRight[i] + smallestLeft);
            }
            smallestLeft = Math.min(smallestLeft, nums[i]);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
