class Solution {
  public boolean canPermutePalindrome(String s) {
    int[] count = new int[256];
    for (char c : s.toCharArray()) {
      count[(int) c]++;
    }
    boolean oddFound = false;
    for (int i = 0; i < 256; i++) {
      if (count[i] % 2 != 0) {
        if (s.length() % 2 == 0 || oddFound) {
          return false;
        }
        oddFound = true;
      }
    }
    return true;
  }
}
