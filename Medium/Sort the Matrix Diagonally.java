class Solution {
  public int[][] diagonalSort(int[][] mat) {
    int numRows = mat.length;
    int numCols = mat[0].length;
    for (int i = 0; i < numRows; i++) {
      sortDiagonal(i, 0, mat);
    }
    for (int i = 0; i < numCols; i++) {
      sortDiagonal(0, i, mat);
    }
    return mat;
  }
  
  private void sortDiagonal(int row, int col, int[][] mat) {
    int numRows = mat.length;
    int numCols = mat[0].length;
    List<Integer> diagonal = new ArrayList<>();
    int diagonalLength = Math.min(numRows - row, numCols - col);
    for (int i = 0; i < diagonalLength; i++) {
      diagonal.add(mat[row + i][col + i]);
    }
    diagonal = countingSort(diagonal);
    for (int i = 0; i < diagonalLength; i++) {
      mat[row + i][col + i] = diagonal.get(i);
    }
  }
  
  private List<Integer> countingSort(List<Integer> list) {
    int min = 1;
    int max = 100;
    int range = max - min + 1;
    int[] frequency = new int[range];
    for (int num : list) {
      frequency[num - min]++;
    }
    List<Integer> sortedList = new ArrayList<>();
    for (int i = 0; i < range; i++) {
      int count = frequency[i];
      while (count-- > 0) {
        sortedList.add(i + min);
      }
    }
    return sortedList;
  }
}
