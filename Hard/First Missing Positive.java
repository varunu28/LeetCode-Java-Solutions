class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            // If in range 0..n & not in correct index then swap
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
            else {
                i++;
            }
        }

        int k = 1;
        // Keep incrementing until the values are its correct position
        while (k < n && nums[k] == k) {
            k++;
        }

        // If empty array or k breaks between the end of the array
        if (n == 0 || k < n) {
            return k;
        }
        
        return nums[0] == k ? k + 1 : k;
    }

    private void swap (int[] nums, int i, int num) {
        int temp = nums[i];
        nums[i] = nums[num];
        nums[num] = temp;
    }
}
