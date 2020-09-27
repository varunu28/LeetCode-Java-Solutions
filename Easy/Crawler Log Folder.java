class Solution {
  public int minOperations(String[] logs) {
    int currPos = 0;
    for (String log : logs) {
      if (log.equals("../")) {
        currPos -= currPos == 0 ? 0 : 1;
      }
      else if (!log.equals("./")) {
        currPos++;
      }
    }
    return currPos;
  }
}
