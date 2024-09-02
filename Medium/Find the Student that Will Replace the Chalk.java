class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = chalk[i] + prefixSum[i - 1]; 
        }
        long total = prefixSum[n - 1];
        long remaining = k % total;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] <= remaining) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
