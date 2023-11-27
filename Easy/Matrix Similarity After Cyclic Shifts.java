class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        for (int j = 0; j < mat.length; j++) {
            if (j % 2 != 0) {
                continue;
            }
            int[] row = mat[j];
            int n = row.length;
            for (int i = 0; i < n; i++) {
                if (row[i] != row[(i + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
