class Solution {
  public double findMaxAverage(int[] nums, int k) {
    Double max = null;
    double sum = 0;
    for (int i = 0; i < k - 1; i++) {
      sum += nums[i];
    }
    int start = 0;
    for (int i = k - 1; i < nums.length; i++) {
      sum += nums[i];
      double avg = sum / k;
      max = max == null ? avg : Math.max(max, avg);
      sum -= nums[start++];
    }
    return max;
  }
}
