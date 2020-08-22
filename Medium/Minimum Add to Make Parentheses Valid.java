class Solution {
  public int minAddToMakeValid(String S) {
    int count = 0;
    int open = 0;
    for (char c : S.toCharArray()) {
      if (c == '(') {
        open++;
      }
      else {
        if (open != 0) {
          open--;
        }
        else {
          count++;
        }
      }
    }
    return count + open;
  }
}
