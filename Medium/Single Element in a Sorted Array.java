class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid + 1] == nums[mid]) {
                if ((end - mid) % 2 == 0) {
                    start = mid + 2;
                } else {
                    end = mid - 1;
                }               
            } else if (nums[mid - 1] == nums[mid]) {
                if ((end - mid) % 2 == 0) {
                    end = mid - 2;
                } else {
                    start = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[start];
    }
}
