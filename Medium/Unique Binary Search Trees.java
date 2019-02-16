class Solution {
    public int numTrees(int n) {
        int[] store = new int[n + 1];
        
        store[0] = 1;
        store[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                store[i] += store[j - 1] * store[i - j];
            }
        }
        
        return store[n];
    }
}
