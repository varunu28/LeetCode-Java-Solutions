class Solution {
  public boolean hasAllCodes(String s, int k) {
    Set<String> set = new HashSet<>();
    int counter = 1 << k;
    for (int i = k; i <= s.length(); i++) {
      String temp = s.substring(i - k, i);
      if (!set.contains(temp)) {
        set.add(temp);
        counter--;
      }
      if (counter == 0) {
        return true;
      }
    }
    return false;
  }
}
