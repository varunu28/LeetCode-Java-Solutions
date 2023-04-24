class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n - 1;
        // Find the first value where decreasing order doesn't holds
        while (pivot > 0 && nums[pivot] <= nums[pivot - 1]) {
            pivot--;
        }
        if (pivot != 0) {
            int i = n - 1;
            // Find the first value from right to left which is greater than element at
            // pivot - 1
            while (nums[i] <= nums[pivot - 1]) {
                i--;
            }
            swap(nums, pivot - 1, i);
        }
        // Reverse the complete array
        int left = pivot;
        int right = n - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int idxOne, int idxTwo) {
        int temp = nums[idxOne];
        nums[idxOne] = nums[idxTwo];
        nums[idxTwo] = temp;
    }
}
