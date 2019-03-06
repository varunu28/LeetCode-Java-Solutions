class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return k;
        }
        
        if (n == 2) {
            return k * k;
        }
        
        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = k;
        ways[2] = k * k;
        
        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] * (k - 1) + ways[i - 2] * (k - 1);
        }
        
        return ways[n];
    }
}
