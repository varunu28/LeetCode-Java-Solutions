class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        for (int i = n / 3; i < n; i += 2) {
            sum += (long) nums[i];
        }
        return sum;
    }
}
