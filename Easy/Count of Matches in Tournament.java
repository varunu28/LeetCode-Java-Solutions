class Solution {
  public int numberOfMatches(int n) {
    int numOfMatches = 0;
    while (n > 1) {
      numOfMatches += n / 2;
      n = n / 2 + n % 2;
    }
    return numOfMatches;
  }
}
