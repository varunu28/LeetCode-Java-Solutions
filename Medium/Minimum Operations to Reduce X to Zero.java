class Solution {
  public int minOperations(int[] nums, int x) {
    int n = nums.length;
    int leftIdx = 0;
    int sum = 0;
    int ans = -1;
    for (; leftIdx < n && sum < x; leftIdx++) {
      sum += nums[leftIdx];
    }
    if (sum == x) {
      ans = leftIdx;
    }
    leftIdx--;
    int rightIdx = n - 1;
    for (; leftIdx >= 0; leftIdx--) {
      sum -= nums[leftIdx];
      while (rightIdx > leftIdx && sum < x) {
        sum += nums[rightIdx--];
      }
      if (sum == x) {
        ans = ans == -1 ? (leftIdx + n - rightIdx - 1) : Math.min(ans, (leftIdx + n - rightIdx - 1));
      }
    }
    return ans;
  }
}
