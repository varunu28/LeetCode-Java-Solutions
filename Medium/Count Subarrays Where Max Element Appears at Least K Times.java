class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = 0;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        long result = 0;
        int start = 0;
        int maxElementsInWindow = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++;
            }
            while (k == maxElementsInWindow) {
                if (nums[start] == maxElement) {
                    maxElementsInWindow--;
                }
                start++;
            }
            result += start;
        }
        return result;
    }
}
