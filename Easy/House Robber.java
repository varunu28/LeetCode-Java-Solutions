class Solution {
  public int rob(int[] nums) {
    int prev = 0;
    int curr = 0;
    for (int num : nums) {
      int temp = curr;
      curr = Math.max(prev + num, curr);
      prev = temp;
    }
    return curr;
  }
}
