class NumArray {
  
  private int[] nums;
  private int[] indexTree;
  private int n;
  
  public NumArray(int[] nums) {
    this.nums = nums;
    this.n = nums.length;
    this.indexTree = new int[n + 1];
    for (int i = 0; i < n; i++) {
      initialize(i, nums[i]);
    }
  }

  public void update(int index, int val) {
    int diff = val - this.nums[index];
		this.nums[index] = val;
		initialize(index, diff);
  }

  public int sumRange(int left, int right) {
    return getSum(right) - getSum(left - 1);
  }
  
  private void initialize(int idx, int value) {
		idx++;
		while (idx <= this.n) {
			this.indexTree[idx] += value;
			idx += (idx & -idx);
		}
  }
  
  private int getSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += this.indexTree[i];
			i -= (i & -i);
		}
		return sum;
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
