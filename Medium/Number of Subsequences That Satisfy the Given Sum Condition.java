class Solution {
    
    private static final int MOD = 1000_000_007;
    
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }
        int result = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + power[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
