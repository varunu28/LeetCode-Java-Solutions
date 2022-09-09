class Solution {
  public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
    int evenSum = 0;
    for (int num : nums) {
      evenSum += num % 2 == 0 ? num : 0;
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < queries.length; i++) {
      int idx = queries[i][1];
      if (nums[idx] % 2 == 0) {
        evenSum -= nums[idx];
      }
      nums[idx] += queries[i][0];
      if (nums[idx] % 2 == 0) {
        evenSum += nums[idx];
      }
      result[i] = evenSum;
    }
    return result;
  }
}
