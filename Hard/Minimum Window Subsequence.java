class Solution {
  public String minWindow(String s1, String s2) {
    String window = "";
    int j = 0;
    int minLength = s1.length() + 1;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) == s2.charAt(j)) {
        j++;
        if (j == s2.length()) {
          int end = i + 1;
          j--;
          while (j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
              j--;
            }
            i--;
          }
          j++;
          i++;
          if (end - i < minLength) {
            minLength = end - i;
            window = s1.substring(i, end);
          }
        }
      }
    }
    return window;
  }
}
