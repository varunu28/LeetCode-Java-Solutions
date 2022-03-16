class Solution {
  public int minSteps(String s, String t) {
    int[] frequency = new int[26];
    for (int i = 0; i < s.length(); i++) {
      frequency[s.charAt(i) - 'a']++;
      frequency[t.charAt(i) - 'a']--;
    }
    int steps = 0;
    for (int i = 0; i < 26; i++) {
      if (frequency[i] > 0) {
        steps += frequency[i];
      }
    }
    return steps;
  }
}
