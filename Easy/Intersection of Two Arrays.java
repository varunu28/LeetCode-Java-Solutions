class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    boolean[][] found = new boolean[1001][2];
    for (int num : nums1) {
      found[num][0] = true;
    }
    int count = 0;
    for (int num : nums2) {
      if (!found[num][1]) {
        if (found[num][0]) {
          count++;
        }
      }
      found[num][1] = true;
    }
    int[] result = new int[count];
    int idx = 0;
    for (int i = 1; i <= 1000; i++) {
      if (found[i][0] && found[i][1]) {
        result[idx++] = i;
      }
    }
    return result;
  }
}
