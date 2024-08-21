class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Arrays.fill(result, -1);
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            count = (nums[i + 1] - nums[i] == 1) ? count + 1 : 1;
            if (count >= k) {
                result[i - k + 2] = nums[i + 1];
            }
        }
        return result;
    }
}
