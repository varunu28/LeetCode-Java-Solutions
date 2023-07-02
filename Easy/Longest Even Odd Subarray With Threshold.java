class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLength = 0;
        int start = 0;
        boolean evenRequired = true;
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] > threshold) {
                idx++;
                start = idx;
                evenRequired = true;
                continue;
            }
            if (nums[idx] % 2 == 0 && !evenRequired) {
                start = idx;
                evenRequired = true;
                continue;
            }
            if (nums[idx] % 2 != 0 && evenRequired) {
                idx++;
                start = idx;
                evenRequired = true;
                continue;
            }
            idx++;
            maxLength = Math.max(maxLength, idx - start);
            evenRequired = !evenRequired;
        }
        return maxLength;
    }
}
