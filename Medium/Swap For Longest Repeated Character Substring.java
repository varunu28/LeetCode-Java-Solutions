class Solution {
  public int maxRepOpt1(String text) {
    int[] count = new int[26];
    for (char c : text.toCharArray()) {
      count[c - 'a']++;
    }
    int maxCount = 0;
    int i = 0;
    while (i < text.length()) {
      char c = text.charAt(i);
      int curr = i;
      int currCount = 0;
      int diff = 0;
      // To skip the same characters before we make a swap
      int swapPoint = i;
      while (curr < text.length() && (text.charAt(curr) == c || diff == 0) && currCount < count[c - 'a']) {
        if (text.charAt(curr) != c) {
          diff++;
          swapPoint = curr - 1;
        }
        currCount++;
        curr++;
      }
      maxCount = Math.max(maxCount, currCount);
      i = swapPoint + 1;
    }
    return maxCount;
  }
}
