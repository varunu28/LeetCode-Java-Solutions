class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                swap(nums, 0, 1);
            }
        }

        int i=0;
        while (i < nums.length) {
            if (i+1 < nums.length && nums[i] > nums[i+1]) {
                swap(nums, i, i+1);
            }

            if (i+1 < nums.length && i+2 < nums.length && nums[i+1] <= nums[i+2]) {
                swap(nums, i+1, i+2);
            }

            i += 2;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
