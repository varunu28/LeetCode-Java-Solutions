class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] counter = new int[26];
    for (char c : s1.toCharArray()) {
      counter[c - 'a']++;
    }
    String targetStr = Arrays.toString(counter);
    int[] targetCounter = new int[26];
    for (int i = 0; i < s1.length() - 1; i++) {
      targetCounter[s2.charAt(i) - 'a']++;
    }
    int start = 0;
    for (int i = s1.length() - 1; i < s2.length(); i++) {
      targetCounter[s2.charAt(i) - 'a']++;
      if (Arrays.toString(targetCounter).equals(targetStr)) {
        return true;
      }
      targetCounter[s2.charAt(start++) - 'a']--;
    }
    return false;
  }
}
