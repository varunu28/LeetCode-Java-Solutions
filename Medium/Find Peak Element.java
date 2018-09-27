class Solution {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        return findPeakElementImpl(nums, 0, nums.length-1);
    }

    private static int findPeakElementImpl(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end)/2;

        if (mid == 0 && nums.length > 1) {
            if (nums[mid] > nums[mid+1]) {
                return mid;
            }
        }
        else if (mid == nums.length-1 && nums.length > 1) {
            if (nums[mid] > nums[mid-1]) {
                return mid;
            }
        }
        else {
            if (nums.length > 1) {
                if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                    return mid;
                }
            }
        }

        int left = findPeakElementImpl(nums, start, mid-1);

        return left == -1 ? findPeakElementImpl(nums, mid+1, end) : left;
    }
}
