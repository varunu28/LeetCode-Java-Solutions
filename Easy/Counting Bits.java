class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i / 2] + i % 2;
        }
        return result;
    }
}
