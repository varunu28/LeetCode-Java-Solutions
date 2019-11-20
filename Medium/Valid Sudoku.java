class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char val = board[i][j];
                    int boxIdx = (i / 3) * 3 + j / 3;
                    if (rowSet[i].contains(val) || colSet[j].contains(val) || boxSet[boxIdx].contains(val)) {
                        return false;
                    }
                    rowSet[i].add(val);
                    colSet[j].add(val);
                    boxSet[boxIdx].add(val);
                }
            }
        }
        return true;
    }
}
