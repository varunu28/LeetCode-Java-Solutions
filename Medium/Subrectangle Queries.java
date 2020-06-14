class SubrectangleQueries {
  List<int[]> modifications;
  int[][] rectangle;
  public SubrectangleQueries(int[][] rectangle) {
    this.rectangle = rectangle;
    modifications = new ArrayList<>();
  }

  public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    modifications.add(new int[]{row1, col1, row2, col2, newValue});
  }

  public int getValue(int row, int col) {
    for (int i = modifications.size() - 1; i >= 0; i--) {
      if (inRange(row, col, modifications.get(i))) {
        return modifications.get(i)[4];
      }
    }
    return rectangle[row][col];
  }
  
  private boolean inRange(int row, int col, int[] modification) {
    return row >= modification[0] && row <= modification[2] && col >= modification[1] && col <= modification[3];
  }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
