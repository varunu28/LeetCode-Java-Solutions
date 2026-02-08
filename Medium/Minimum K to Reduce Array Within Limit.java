class Solution {
    public int minimumK(int[] nums) {
        long start = 1;
        long end = 0;
        for (int num : nums) {
            end += num;
        }
        while (start < end) {
            long mid = (start + end) / 2;
            if (isPossible(nums, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (int) start;
    }

    private boolean isPossible(int[] nums, long k) {
        long count = 0;
        for (int num : nums) {
            count += num / k;
            count += num % k == 0 ? 0 : 1;
        }
        return count <= k * k;
    }
}
