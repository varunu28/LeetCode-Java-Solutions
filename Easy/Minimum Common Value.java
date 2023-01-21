class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int idxOne = 0;
        int idxTwo = 0;
        while (idxOne < nums1.length && idxTwo < nums2.length) {
            if (nums1[idxOne] < nums2[idxTwo]) {
                idxOne++;
            } else if (nums2[idxTwo] < nums1[idxOne]) {
                idxTwo++;
            } else {
                return nums1[idxOne];
            }
        }
        return -1;
    }
}
