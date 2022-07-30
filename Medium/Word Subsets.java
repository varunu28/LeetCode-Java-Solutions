class Solution {
  public List<String> wordSubsets(String[] words1, String[] words2) {
    int[] word2MaxCount = new int[26];
    for (String word : words2) {
      int[] count = getFrequencyArray(word);
      for (int i = 0; i < 26; i++) {
        word2MaxCount[i] = Math.max(word2MaxCount[i], count[i]);
      }
    }
    List<String> result = new ArrayList<>();
    for (String word : words1) {
      int[] count = getFrequencyArray(word);
      for (int i = 0; i < 26; i++) {
        if (count[i] < word2MaxCount[i]) {
          break;
        }
        if (i == 25) {
          result.add(word);
        }
      }
    }
    return result;
  }
  
  private static int[] getFrequencyArray(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    return count;
  }
}
