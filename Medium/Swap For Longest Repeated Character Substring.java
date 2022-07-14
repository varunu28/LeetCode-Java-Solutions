class Solution {
  public int maxRepOpt1(String text) {
    int[] frequency = new int[26];
    for (char c : text.toCharArray()) {
      frequency[c - 'a']++;
    }
    int maxRepeatingLength = 0;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      int j = i;
      int count = 0;
      int diff = 0;
      while (j < text.length() && (c == text.charAt(j) || diff == 0) && count < frequency[c - 'a']) {
        if (c != text.charAt(j)) {
          diff++;
          i = j - 1;
        }
        count++;
        j++;
      }
      maxRepeatingLength = Math.max(maxRepeatingLength, count);
    }
    for (int i = text.length() - 1; i >= 0; i--) {
      char c = text.charAt(i);
      int count = 0;
      int diff = 0;
      int j = i;
      while (j >= 0 && (c == text.charAt(j) || diff == 0) && count < frequency[c - 'a']) {
        if (c != text.charAt(j)) {
          diff++;
          i = j + 1;
        }
        count++;
        j--;
      }
      maxRepeatingLength = Math.max(maxRepeatingLength, count);
    }
    return maxRepeatingLength;
  }
}
