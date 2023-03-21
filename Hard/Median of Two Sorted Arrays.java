class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = nums2.length * 2;
        while (low <= high) {
            int midTwo = (low + high) / 2;
            int midOne = nums1.length + nums2.length - midTwo;
            double leftOne = (midOne == 0) ? Integer.MIN_VALUE : nums1[(midOne - 1) / 2];	
            double leftTwo = (midTwo == 0) ? Integer.MIN_VALUE : nums2[(midTwo - 1) / 2];
            double rightOne = (midOne == nums1.length * 2) ? Integer.MAX_VALUE : nums1[(midOne) / 2];
            double rightTwo = (midTwo == nums2.length * 2) ? Integer.MAX_VALUE : nums2[(midTwo) / 2];
            if (leftOne > rightTwo) {
                low = midTwo + 1;
            } else if (leftTwo > rightOne) {
                high = midTwo - 1;
            } else {
                return (Math.max(leftOne, leftTwo) + Math.min(rightOne, rightTwo)) / 2;	
            }
        }
        return -1;
    }
}
