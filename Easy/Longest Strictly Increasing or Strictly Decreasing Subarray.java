class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int idx = 0;
        int n = nums.length;
        while (idx < n) {
            if (idx == n - 1 || nums[idx + 1] == nums[idx]) {
                idx++;
                continue;
            }
            boolean increase = nums[idx + 1] > nums[idx];
            int start = idx;
            while (idx + 1 < n && (
                (increase && nums[idx + 1] > nums[idx]) || 
                (!increase && nums[idx + 1] < nums[idx]))) {
                idx++;
            }
            max = Math.max(max, idx - start + 1);
        }
        return max;
    }
}
