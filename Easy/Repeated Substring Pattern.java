class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    for (int i = n / 2; i >= 1; i--) {
      if (n % i == 0) {
        int count = n / i;
        StringBuilder sb = new StringBuilder();
        String sub = s.substring(0, i);
        while (count-- > 0) {
          sb.append(sub);
        }
        if (sb.toString().equals(s)) {
          return true;
        }
      }
    }
    return false;
  }
}
