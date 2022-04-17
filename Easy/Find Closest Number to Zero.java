class Solution {
  public int findClosestNumber(int[] nums) {
    int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    for (int num : nums) {
      int distance = Math.abs(num);
      if (distance <= result[0]) {
        if (distance < result[0]) {
          result[0] = distance;
          result[1] = num;
        } else {
          result[1] = Math.max(num, result[1]);
        }
      }
    }
    return result[1];
  }
}
