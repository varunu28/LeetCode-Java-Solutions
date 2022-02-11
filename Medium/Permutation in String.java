class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s2.length() < s1.length()) {
      return false;
    }
    int[] frequency = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      frequency[s1.charAt(i) - 'a']++;
      frequency[s2.charAt(i) - 'a']--;
    }
    if (allZeroArray(frequency)) {
      return true;
    }
    for (int i = s1.length(); i < s2.length(); i++) {
      frequency[s2.charAt(i) - 'a']--;
      frequency[s2.charAt(i - s1.length()) - 'a']++;
      if (allZeroArray(frequency)) {
        return true;
      }
    }
    return false;
  }

  private boolean allZeroArray(int[] frequency) {
    for (int count : frequency) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
}
