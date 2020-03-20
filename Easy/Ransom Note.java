class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] counter = new int[26];
    for (char c : ransomNote.toCharArray()) {
      counter[c - 'a']++;
    }
    for (char c : magazine.toCharArray()) {
      counter[c - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (counter[i] > 0) {
        return false;
      }
    }
    return true;
  } 
}
