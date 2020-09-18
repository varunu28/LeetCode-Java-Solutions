class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int counter = m + n - 1;
    int num1End = m - 1;
    int num2End = n - 1;
    while (num1End >= 0 || num2End >= 0) {
      int val = -1;
      if (num1End >= 0 && num2End >= 0) {
        if (nums1[num1End] > nums2[num2End]) {
          val = nums1[num1End--];
        }
        else {
          val = nums2[num2End--];
        }
      }
      else if (num1End >= 0 || num2End < 0) {
        val = nums1[num1End--];
      }
      else {
        val = nums2[num2End--];
      }
      nums1[counter--] = val;
    }
  }
}
