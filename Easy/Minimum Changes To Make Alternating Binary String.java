class Solution {
  public int minOperations(String s) {
    int numOfChanges = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) - '0' != i % 2) {
        numOfChanges++;
      }
    }
    return Math.min(numOfChanges, s.length() - numOfChanges);
  }
}
