class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] result = new int[n / 3][3];
        int idx = 0;
        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new int[][]{};
            }
            result[idx++] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
        }
        return result;
    }
}
