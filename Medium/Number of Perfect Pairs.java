class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = Math.abs(nums[i]);
        }
        Arrays.sort(sorted);
        long result = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx < n && sorted[idx] <= 2 * Math.abs(sorted[i])) {
                idx++;
            }
            result += idx - i - 1;
        }
        return result;
    }
}
