class NumArray {
    int[] fen;
    int[] nums;
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        fen = new int[n + 1];
        init();
    }

    private void init () {
        if (n == 0) {
            return;
        }

        // Compute the pre-sum
        fen[1] = nums[0];
        for (int i = 1; i < n; i++) {
            fen[i + 1] = fen[i] + nums[i];
        }

        for (int i = n; i > 0; i--) {
            // Removing the value of parent for each node
            int parent = i - (i & -i);
            if (parent >= 0) {
                fen[i] -= fen[parent];
            }
        }
    }

    public void update(int i, int val) {
        // Find the difference between previous and current value
        int extra = val - nums[i];

        // Update the actual array with the new val
        nums[i] = val;

        // Update the tree with the extra value to all the parents 
        increment(i, extra);
    }

    private void increment (int i, int extra) {
        i++;
        while (i <= n) {
            fen[i] += extra;
            i = i + (i & -i);
        }
    }

    public int sumRange(int i, int j) {
        // Similar to pre sum from 0 to j - pre sum from 0 to i
        return getSum(j + 1) - getSum(i);
    }

    private int getSum (int i) {
        int res = 0;
        while (i > 0) {
            res += fen[i];
            i = i - (i & -i);
        }

        return res;
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
