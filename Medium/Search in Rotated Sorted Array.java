class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            // Is left half sorted?
            if (nums[start] <= nums[mid]) {
                // Is target present in left half?
                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid - 1; // Eliminate right half
                } else {
                    start = mid + 1; // Eliminate left half
                }
            } else {
                // Is target present in right half?
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1; // Eliminate left half
                } else {
                    end = mid - 1; // Eliminate right half
                }
            }
        }
        return -1;
    }
}
