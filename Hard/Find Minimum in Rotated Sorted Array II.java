class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int minVal = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end)/2;
            if (((mid > 0 ? nums[mid] < nums[mid-1] : true) && (mid < nums.length-1 ? nums[mid] < nums[mid+1] : true))) {
                return nums[mid];
            }
            else if (nums[mid] < nums[end]) {
                end = mid;
            }
            else if (nums[mid] > nums[end]){
                start = mid+1;
            }
            else {
                end--;
            }

            minVal = Math.min(nums[mid], minVal);
        }

        return minVal;
    }
}
