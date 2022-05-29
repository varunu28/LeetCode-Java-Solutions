class Solution {
  public int rearrangeCharacters(String s, String target) {
    int[] frequencyS = new int[26];
    int[] frequencyTarget = new int[26];
    for(char ch : s.toCharArray()) {
      frequencyS[ch-'a']++;
    }
    for(char ch : target.toCharArray()) {
      frequencyTarget[ch-'a']++;
    }
    int maxCopies = Integer.MAX_VALUE;
    for(char ch : target.toCharArray()) {
      maxCopies = Math.min(maxCopies, frequencyS[ch - 'a'] / frequencyTarget[ch - 'a']);
    }
    return maxCopies;
  }
}
