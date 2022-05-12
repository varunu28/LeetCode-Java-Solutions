class Solution {
  public String largestGoodInteger(String num) {
    int largestIdx = -1;
    for (int i = 0; i < num.length() - 2; i++) {
      if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
        if (largestIdx == -1 || num.substring(largestIdx, largestIdx + 3).compareTo(num.substring(i, i + 3)) < 0) {
          largestIdx = i;
        }
      }
    }
    return largestIdx == -1 ? "" : num.substring(largestIdx, largestIdx + 3);
  }
}
