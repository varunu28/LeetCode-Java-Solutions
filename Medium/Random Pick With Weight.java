class Solution {

    private final int[] prefixSum;
    private final int totalSum;

    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            this.prefixSum[i] = sum;
        }
        this.totalSum = sum;
    }
    
    public int pickIndex() {
        double target = totalSum * Math.random();
        int low = 0;
        int high = prefixSum.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target > prefixSum[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
