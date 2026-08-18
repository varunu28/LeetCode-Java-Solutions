class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (n == k) {
            int result = nums[0];
            for (int num : nums) {
                result = Math.max(result, num);
            }
            return result;
        }
        int[] counter = new int[51];
        for (int num : nums) {
            counter[num]++;
        }
        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (counter[i] == 1) {
                    return i;
                }
            }
        }
        int result = -1;
        if (counter[nums[0]] == 1) {
            result = Math.max(result, nums[0]);
        }
        if (counter[nums[n - 1]] == 1) {
            result = Math.max(result, nums[n - 1]);
        }
        return result;
    }
}
