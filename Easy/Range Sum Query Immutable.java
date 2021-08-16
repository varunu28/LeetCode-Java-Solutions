class NumArray {

  int[] sumArray;
  
  public NumArray(int[] nums) {
    sumArray = new int[nums.length];
    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      sumArray[i] = currSum;
    }
  }

  public int sumRange(int left, int right) {
    return sumArray[right] - (left == 0 ? 0 : sumArray[left - 1]);
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
