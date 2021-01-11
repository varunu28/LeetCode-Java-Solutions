class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int idx = m + n - 1;
    int numsOneIdx = m - 1;
    int numsTwoIdx = n - 1;
    while (numsOneIdx >= 0 || numsTwoIdx >= 0) {
      int val = -1;
      if (numsOneIdx >= 0 && numsTwoIdx >= 0) {
        if (nums1[numsOneIdx] > nums2[numsTwoIdx]) {
          val = nums1[numsOneIdx--];
        } else {
          val = nums2[numsTwoIdx--];
        }
      } else if (numsOneIdx >= 0 && numsTwoIdx < 0) {
        val = nums1[numsOneIdx--];
      } else {
        val = nums2[numsTwoIdx--];
      }
      nums1[idx--] = val;
    }
  }
}
