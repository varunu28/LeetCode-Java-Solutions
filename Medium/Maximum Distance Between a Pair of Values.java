class Solution {
  public int maxDistance(int[] nums1, int[] nums2) {
    int maxDistance = 0;
    for (int i = 0; i < nums1.length; i++) {
      int idx = getValidIdx(nums2, i, nums2.length - 1, nums1[i]);
      if (idx != -1) {
        maxDistance = Math.max(maxDistance, idx - i);
      }
    }
    return maxDistance;
  }
  
  private int getValidIdx(int[] nums, int start, int end, int limit) {
    int idx = -1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] >= limit) {
        idx = Math.max(idx, mid);
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return idx;
  }
}
