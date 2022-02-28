class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int endIdxOne = m - 1;
    int endIdxTwo = n - 1;
    int currIdx = m + n - 1;
    while (endIdxOne >= 0 || endIdxTwo >= 0) {
      if (endIdxOne >= 0 && endIdxTwo >= 0) {
        if (nums1[endIdxOne] > nums2[endIdxTwo]) {
          nums1[currIdx--] = nums1[endIdxOne--];
        } else {
          nums1[currIdx--] = nums2[endIdxTwo--];          
        }
      } else if (endIdxOne >= 0 && endIdxTwo < 0) {
        nums1[currIdx--] = nums1[endIdxOne--];
      } else {
        nums1[currIdx--] = nums2[endIdxTwo--];
      }
    }
  }
}
