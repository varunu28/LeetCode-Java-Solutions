class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int oneStep = 2;
        int twoStep = 1;
        int all = 0;
        
        for (int i=2;i<n;i++) {
            all = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = all;
        }
        
        return all;
    }
}
