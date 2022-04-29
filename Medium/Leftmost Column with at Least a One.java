/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    List<Integer> dimension = binaryMatrix.dimensions();
    int numRows = dimension.get(0);
    int numCols = dimension.get(1);
    int currRow = 0;
    int currCol = numCols - 1;
    while (currRow < numRows && currCol >= 0) {
      if (binaryMatrix.get(currRow, currCol) == 0) {
        currRow++;
      } else {
        currCol--;
      }
    }
    return currCol == numCols - 1 ? -1 : currCol + 1;
  }
}
