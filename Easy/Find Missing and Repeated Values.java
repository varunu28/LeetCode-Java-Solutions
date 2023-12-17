class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] frequency = new int[n * n + 1];
        for (int[] row : grid) {
            for (int num : row) {
                frequency[num]++;
            }
        }
        int[] result = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (frequency[i] == 0) {
                result[1] = i;
            }
            if (frequency[i] == 2) {
                result[0] = i;
            }
        }
        return result;
    }
}
