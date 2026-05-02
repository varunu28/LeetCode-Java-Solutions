class Solution {
    public int maxRotateFunction(int[] nums) {
        int function = 0;
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            function += i * nums[i];
        }
        int result = function;
        for (int i = n - 1; i > 0; i--) {
            function += sum - n * nums[i];
            result = Math.max(result, function);
        }
        return result;
    }
}
