class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int max = -1;
        int left = 0;
        int curr = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            curr += nums[right];
            while (curr > sum - x && left <= right) {
                curr -= nums[left++];
            }
            if (curr == sum - x) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max != -1 ? n - max : -1;
    }
}
