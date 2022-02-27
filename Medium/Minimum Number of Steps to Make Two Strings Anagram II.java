class Solution {
  public int minSteps(String s, String t) {
    int[] frequency = new int[26];
    for (char c : s.toCharArray()) {
      frequency[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      frequency[c - 'a']--;
    }
    int totalSteps = 0;
    for (int i = 0; i < 26; i++) {
      totalSteps += Math.abs(frequency[i]);
    }
    return totalSteps;
  }
}
