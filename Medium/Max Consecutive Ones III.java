class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int flipped = 0;
        int n = nums.length;
        int max = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                flipped++;
            }
            end++;
            while (start < end && flipped > k) {
                if (nums[start] == 0) {
                    flipped--;
                }
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
