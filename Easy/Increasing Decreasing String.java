class Solution {
  public String sortString(String s) {
    int[] counter = new int[26];
    for (char c : s.toCharArray()) {
      counter[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    while (sb.length() != s.length()) {
      addLowerToHiger(sb, counter);
      addHigherToLower(sb, counter);
    }
    return sb.toString();
  }
  
  private void addLowerToHiger(StringBuilder sb, int[] counter) {
    for (int i = 0; i < 26; i++) {
      if (counter[i] != 0) {
        sb.append((char) (97 + i));
        counter[i]--;
      }
    }
  }
  
  private void addHigherToLower(StringBuilder sb, int[] counter) {
    for (int i = 25; i >= 0; i--) {
      if (counter[i] != 0) {
        sb.append((char) (97 + i));
        counter[i]--;
      }
    }
  }
}
