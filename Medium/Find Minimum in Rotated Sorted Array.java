class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            // Is left half sorted?
            if (nums[start] <= nums[mid]) {
                // Minimum in left sorted will always be the leftmost element
                result = Math.min(result, nums[start]); 
                start = mid + 1;
            } else {
                // Minimum in right sorted will always be at mid as it is start of array
                result = Math.min(result, nums[mid]);
                end = mid - 1;
            }
        }
        return result;
    }
}
