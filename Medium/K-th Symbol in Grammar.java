class Solution {
    public int kthGrammar(int n, int k) {
        return depthFirstSearch(n, k, 0);
    }

    private int depthFirstSearch(int n, int k, int root) {
        if (n == 1) {
            return root;
        }
        int nodeCount = (int) Math.pow(2, n - 1);
        if (k > (nodeCount / 2)) {
            int nextRoot = (root == 0) ? 1 : 0;
            return depthFirstSearch(n - 1, k - (nodeCount / 2), nextRoot);
        }
        int nextRoot = (root == 0) ? 0 : 1;
        return depthFirstSearch(n - 1, k, nextRoot);
    }
}
