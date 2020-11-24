class Solution {
  public String getSmallestString(int n, int k) {
    StringBuilder sb = new StringBuilder();
    for (int idx = 0; idx < n; idx++) {
      for (int currChar = 26; currChar > 0; currChar--) {
        if (currChar <= k && k - currChar >= (n - idx - 1)) {
          sb.append((char) (97 + currChar - 1));
          k -= currChar;
          break;
        }
      }
    }
    return sb.reverse().toString();
  }
}
