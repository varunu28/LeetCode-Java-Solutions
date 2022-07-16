class Solution {
  public int minimumMoves(String s) {
    int numOfMoves = 0;
    int idx = 0;
    while (idx < s.length()) {
      if (s.charAt(idx) == 'X') {
        idx += 3;
        numOfMoves++;
      } else {
        idx++;
      }
    }
    return numOfMoves;
  }
}
