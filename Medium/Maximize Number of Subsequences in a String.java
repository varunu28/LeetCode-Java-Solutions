class Solution {
  public long maximumSubsequenceCount(String text, String pattern) {
    long result = 0;
    int countCharOne = 0;
    int countCharTwo = 0;
    for (char c : text.toCharArray()) {
      if (c == pattern.charAt(1)) {
        result += countCharOne;
        countCharTwo++;
      }
      if (c == pattern.charAt(0)) {
        countCharOne++;
      }
    }
    return result + Math.max(countCharOne, countCharTwo);
  }
}
