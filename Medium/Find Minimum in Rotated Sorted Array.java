class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (start + end)/2;

            if (((mid > 0 ? nums[mid] < nums[mid-1] : true) && (mid < nums.length-1 ? nums[mid] < nums[mid+1] : true))) {
                return nums[mid];
            }
            else if (nums[mid] < nums[end]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return -1;
    }
}
