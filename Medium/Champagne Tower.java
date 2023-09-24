class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] glass = new double[query_row + 2];
        glass[0] = poured;
        for (int row = 1; row <= query_row; row++) {
            for (int idx = row; idx >= 0; idx--) {
                glass[idx] = Math.max(0.0, (glass[idx] - 1) / 2);
                glass[idx + 1] += glass[idx];
            }
        }
        return Math.min(glass[query_glass], 1.0);
    }
}
