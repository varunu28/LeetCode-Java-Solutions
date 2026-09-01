class Solution {
    public String[] createGrid(int m, int n) {
        StringBuilder[] temp = new StringBuilder[m];
        for (int i = 0; i < m; i++) {
            temp[i] = new StringBuilder();
            temp[i].append("#".repeat(n));
        }
        for (int i = 0; i < n; i++) {
            temp[0].setCharAt(i, '.');
        }
        for (int i = 0; i < m; i++) {
            temp[i].setCharAt(n - 1, '.');
        }
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = temp[i].toString();
        }
        return result;
    }
}
