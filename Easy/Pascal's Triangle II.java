class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> lastRow = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> copy = new ArrayList<>(lastRow);
      lastRow.clear();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          lastRow.add(1);
        } else {
          lastRow.add(copy.get(j - 1) + copy.get(j));
        }
      }
    }
    return lastRow;
  }   
}
