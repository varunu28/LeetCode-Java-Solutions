class Solution {
    public int minSensors(int n, int m, int k) {
        int coverage = 2 * k + 1;
        int rows = (n + coverage - 1) / coverage;
        int cols = (m + coverage - 1) / coverage;
        return rows * cols;
    }
}
