class Solution {
  public void nextPermutation(int[] nums) {
    boolean flag = true;
    int right = nums.length - 1;
    int start = right;
    while (start >= 1) {
      if (nums[start] > nums[start - 1]) {
        int idx = right;
        while (nums[idx] <= nums[start - 1]) {
          idx--;
        }
        int temp = nums[start - 1];
        nums[start - 1] = nums[idx];
        nums[idx] = temp;
        flag = false;
        break;
      }
      start--;
    }
    if (flag) {
      Arrays.sort(nums);
      return;
    }
    while (start < right) {
      int temp = nums[start];
      nums[start] = nums[right];
      nums[right] = temp;
      start++;
      right--;
    }
  }
}
