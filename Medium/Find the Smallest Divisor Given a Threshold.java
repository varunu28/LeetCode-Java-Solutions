class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = -1;
        for (int num : nums) {
            end = Math.max(end, num);
        }
        int smallest = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isValid(nums, mid, threshold)) {
                smallest = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return smallest;
    }

    private boolean isValid(int[] nums, int divisor, int threshold) {
        int sum = 0;        
        for (int num : nums) {
            sum += num / divisor;
            if (num % divisor > 0) {
                sum++;
            }
        }
        return sum <= threshold;
    }
}
