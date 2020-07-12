class Solution {
  public int numSub(String s) {
    long ans = 0;
    for (int i = 0; i < s.length(); i++) {
      long count = 0;
      while (i < s.length() && s.charAt(i) == '1') {
        i++;
        count++;
      }
      ans = (ans + (count * (count + 1)) / 2) % 1000000007;
    }
    return (int) ans;
  }
}
