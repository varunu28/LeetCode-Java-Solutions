class Solution {
  public int minimumMoves(String s) {
    int numOfMoves = 0;
    int idx = 0;
    while (idx < s.length()) {
      if (s.charAt(idx) == 'X') {
        idx += 2;
        numOfMoves++;
      }
      idx++;
    }
    return numOfMoves;
  }
}
