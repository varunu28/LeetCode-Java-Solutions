class NumArray {
  int[] cumulativeSum;
  int n;
  public NumArray(int[] nums) {
    n = nums.length;
    cumulativeSum = new int[n];
    int currSum = 0;
    for (int i = 0; i < n; i++) {
      currSum += nums[i];
      cumulativeSum[i] = currSum;
    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return cumulativeSum[j];
    }
    return cumulativeSum[j] - cumulativeSum[i - 1];
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
