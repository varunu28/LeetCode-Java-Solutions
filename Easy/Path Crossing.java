class Solution {
  int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  public boolean isPathCrossing(String path) {
    Set<String> set = new HashSet<>();
    int currX = 0;
    int currY = 0;
    String dirSymbol = "NSEW";
    set.add(currX + "|" + currY);
    for (char c : path.toCharArray()) {
      int dirIdx = dirSymbol.indexOf(c);
      currX += dirs[dirIdx][0];
      currY += dirs[dirIdx][1];
      String hash = currX + "|" + currY;
      if (set.contains(hash)) {
        return true;
      }
      set.add(hash);
    }
    return false;
  }
}
