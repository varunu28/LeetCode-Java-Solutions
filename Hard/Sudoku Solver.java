class Solution {
    public void solveSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        List<Set<Integer>> rowState = new ArrayList<>();
        List<Set<Integer>> colState = new ArrayList<>();
        List<Set<Integer>> blockState = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            rowState.add(new HashSet<>());
            colState.add(new HashSet<>());
            blockState.add(new HashSet<>());
        }
        int setCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != '.') {
                    setCount++;
                    int value = Character.getNumericValue(board[i][j]);
                    int blockKey = findSudokuBlock(i, j);
                    rowState.get(i).add(value);
                    colState.get(j).add(value);
                    blockState.get(blockKey).add(value);
                }
            }
        }
        boolean[] found = {false};
        int movesRequired = rows * cols - setCount;
        recurse(board, rowState, colState, blockState, 0, 0, movesRequired, found);
    }

    private void recurse(char[][] board, List<Set<Integer>> rowState, List<Set<Integer>> colState, List<Set<Integer>> blockState, int row, int col, int movesRequired, boolean[] found) {
        if (movesRequired == 0) {
            found[0] = true;
            return;
        }
        if (board[row][col] != '.') {
            int nextRow = (col == 8) ? row + 1 : row;
            int nextCol = (col == 8) ? 0 : col + 1;
            recurse(board, rowState, colState, blockState, nextRow, nextCol, movesRequired, found);
            return;
        }
        int blockKey = findSudokuBlock(row, col);
        for (int i = 1; i <= 9; i++) {
            if (rowState.get(row).contains(i) || colState.get(col).contains(i) || blockState.get(blockKey).contains(i)) {
                continue;
            }
            board[row][col] = (char) (i + '0');
            rowState.get(row).add(i);
            colState.get(col).add(i);
            blockState.get(blockKey).add(i);
            int nextRow = (col == 8) ? row + 1 : row;
            int nextCol = (col == 8) ? 0 : col + 1;
            recurse(board, rowState, colState, blockState, nextRow, nextCol, movesRequired - 1, found);
            if (found[0]) {
                return;
            }
            board[row][col] = '.';
            rowState.get(row).remove(i);
            colState.get(col).remove(i);
            blockState.get(blockKey).remove(i);
        }
    }

    private int findSudokuBlock(int row, int col) {
        return row / 3 * 3 + col / 3;
    }
}
