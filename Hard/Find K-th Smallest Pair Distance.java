class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int count = countPairs(nums, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countPairs(int[] nums, int distance) {
        int count = 0;
        int n = nums.length;
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (nums[i] - nums[left] > distance) {
                left++;
            }
            count += i - left;
        }
        return count;
    }
}
