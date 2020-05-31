class Solution {
  int maxOne = Integer.MIN_VALUE;
  int maxTwo = Integer.MIN_VALUE;
  public int maxProduct(int[] nums) {
    for (int num : nums) {
      if (maxOne < num) {
        maxTwo = maxOne;
        maxOne = num;
      }
      else if (maxTwo < num) {
        maxTwo = num;
      }
    }
    return (maxOne - 1) * (maxTwo - 1);
  }
}
