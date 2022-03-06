class Solution {
  public List<String> cellsInRange(String s) {
    List<String> cells = new ArrayList<>();
    String[] splits = s.split(":");
    char startCol = splits[0].charAt(0);
    int startRow = Character.getNumericValue(splits[0].charAt(1));
    char endCol = splits[1].charAt(0);
    int endRow = Character.getNumericValue(splits[1].charAt(1));
    for (char c = startCol; c <= endCol; c = (char) (c + 1)) {
      for (int j = startRow; j <= endRow; j++) {
        cells.add(c + "" + j);
      }
    }
    return cells;
  }
}
