class Solution {
  public boolean checkValidString(String s) {
    int low = 0;
    int high = 0;
    for (char c : s.toCharArray()) {
      low += c == '(' ? 1 : -1;
      high += c != ')' ? 1 : -1;
      if (high < 0) {
        break;
      }
      low = Math.max(low, 0);
    }
    return low == 0;
  }
}
