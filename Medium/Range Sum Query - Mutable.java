class NumArray {

  private BIT bit;
  private int[] nums;
  
  public NumArray(int[] nums) {
    this.bit = new BIT(nums.length);
    this.nums = nums;
    for (int i = 0; i < nums.length; i++) {
      this.bit.update(i + 1, nums[i]);
    }
  }

  public void update(int index, int val) {
    int delta = val - nums[index];
    this.bit.update(index + 1, delta);
    this.nums[index] = val;
  }

  public int sumRange(int left, int right) {
    return this.bit.query(right + 1) - this.bit.query(left);
  }
  
  private static class BIT {
    
    private int[] sum;
    
    public BIT(int n) {
      this.sum = new int[n + 1];
    }
    
    private void update(int idx, int delta) {
      while (idx < sum.length) {
        sum[idx] += delta;
        idx += (idx & -idx);
      }
    }
    
    private int query(int idx) {
      int result = 0;
      while (idx > 0) {
        result += sum[idx];
        idx -= (idx & -idx); 
      }
      return result;
    }
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
