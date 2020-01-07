class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    for (int i = n / 2; i >= 0; i--) {
      if (i != 0 && n % i == 0) {
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
