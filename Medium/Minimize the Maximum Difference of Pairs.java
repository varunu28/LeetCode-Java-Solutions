class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = 0;
        int end = nums[n - 1] - nums[0];
        while (start < end) {
            int mid = (start + end) / 2;
            if (countValidPairs(nums, mid) >= p) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    private static int countValidPairs(int[] nums, int limit) {
        int idx = 0;
        int count = 0;
        while (idx < nums.length - 1) {
            if (nums[idx + 1] - nums[idx] <= limit) {
                count++;
                idx++;
            }
            idx++;
        }
        return count;
    }
}
