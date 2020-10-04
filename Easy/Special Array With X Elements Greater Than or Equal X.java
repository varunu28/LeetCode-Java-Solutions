class Solution {
  public int specialArray(int[] nums) {
    int[] count = new int[1001];
    for (int num : nums) {
      count[num]++;
    }
    int n = nums.length;
    for (int i = 0; i < 1001; i++) {
      if (n == i) {
        return i;
      }
      n -= count[i];
    }
    return -1;
  }
}
