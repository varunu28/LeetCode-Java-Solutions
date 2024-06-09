class Solution {
    public int numberOfChild(int n, int k) {
        int factor = k / (n - 1);
        int remainder = k % (n - 1);
        return factor % 2 == 0 ? remainder : n - 1 - remainder;
    }
}
