class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int minValue = 5001;
        while (start <= end) {
            int mid = (start + end) / 2;
            minValue = Math.min(minValue, nums[mid]);
            if (nums[end] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minValue;
    }
}
