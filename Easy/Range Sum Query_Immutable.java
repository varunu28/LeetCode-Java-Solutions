class NumArray {
  int[] rangeSum;
  public NumArray(int[] nums) {
    rangeSum = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      rangeSum[i] = sum;
    }
  }

  public int sumRange(int i, int j) {
    int currSum = rangeSum[j];
    int endIdx = i - 1;
    if (endIdx >= 0) {
      currSum -= rangeSum[endIdx];
    }
    return currSum;
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
