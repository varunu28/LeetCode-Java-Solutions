class Solution {
    public int countElements(int[] nums, int k) {
        if (k == 0) {
            return nums.length;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        int threshold = nums[n - k];
        for (int num : nums) {
            if (num < threshold) {
                result++;
            }
        }
        return result;
    }
}
