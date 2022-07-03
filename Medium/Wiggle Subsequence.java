class Solution {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    int[] increasing = new int[nums.length];
    int[] decreasing = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          increasing[i] = Math.max(increasing[i], decreasing[j] + 1);
        } else if (nums[i] < nums[j]) {
          decreasing[i] = Math.max(decreasing[i], increasing[j] + 1);
        }
      }
    }
    return 1 + Math.max(decreasing[nums.length - 1], increasing[nums.length - 1]);
  }
}
