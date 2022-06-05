class Solution {
  public int totalNQueens(int n) {
    return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
  }
  
  private int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> columns, int n) {
    if (row == n) {
      return 1;
    }
    int possibleSolutions = 0;
    for (int col = 0; col < n; col++) {
      int currDiagonal = row - col;
      int currAntiDiagonal = row + col;
      if (columns.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
        continue;
      }
      columns.add(col);
      diagonals.add(currDiagonal);
      antiDiagonals.add(currAntiDiagonal);

      possibleSolutions += backtrack(row + 1, diagonals, antiDiagonals, columns, n);
      
      columns.remove(col);
      diagonals.remove(currDiagonal);
      antiDiagonals.remove(currAntiDiagonal);
    }
    return possibleSolutions;
  }
}
