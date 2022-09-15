class Solution {
  public int[] getAverages(int[] nums, int k) {
    int[] result = new int[nums.length];
    Arrays.fill(result, -1);
    int subarrayLength = 2 * k + 1;
    if (subarrayLength > nums.length) {
      return result;
    }
    long sum = 0;
    for (int i = 0; i < subarrayLength; i++) {
      sum += nums[i];
    }
    int startIdx = 0;
    int endIdx = subarrayLength;
    for (int i = k; i < nums.length - k; i++) {
      result[i] = (int) (sum / subarrayLength);
      sum -= nums[startIdx++];
      if (endIdx < nums.length) {
        sum += nums[endIdx++];
      }
    }
    return result;
  }
}
