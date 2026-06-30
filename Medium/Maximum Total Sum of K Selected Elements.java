class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        long sum = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0 && k-- > 0; i--) {
            long num = (long) nums[i];
            sum += mul > 0 ? num * mul : num;
            mul--;
        }
        return sum;
    }
}
