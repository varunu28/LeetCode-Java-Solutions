class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                result[i] = nums[start] * nums[start];
                start++;
            } else {
                result[i] = nums[end] * nums[end];
                end--;
            }
        }
        return result;
    }
}
