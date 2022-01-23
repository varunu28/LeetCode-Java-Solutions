class Solution {
  public int countElements(int[] nums) {
    int minValue = nums[0];
    int maxValue = nums[0];
    for (int num : nums) {
      minValue = Math.min(minValue, num);
      maxValue = Math.max(maxValue, num);
    }
    int count = 0;
    for (int num : nums) {
      if (num > minValue && num < maxValue) {
        count++;
      }
    }
    return count;
  }
}
