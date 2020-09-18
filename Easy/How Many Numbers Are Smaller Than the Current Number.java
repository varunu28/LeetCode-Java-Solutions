class Solution {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] counter = new int[101];
    for (int num : nums) {
      counter[num]++;
    }
    int sum = 0;
    int[] preSum = new int[101];
    for (int i = 0; i < 101; i++) {
      preSum[i] = sum;
      sum += counter[i];
    }
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ans[i] = preSum[nums[i]];
    }
    return ans;
  }
}
