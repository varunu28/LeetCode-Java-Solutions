class Solution {
  public List<String> commonChars(String[] words) {
    int[] commonFrequency = new int[26];
    Arrays.fill(commonFrequency, Integer.MAX_VALUE);
    for (String word : words) {
      int[] wordFreq = new int[26];
      for (char c : word.toCharArray()) {
        wordFreq[c - 'a']++;
      }
      for (int i = 0; i < 26; i++) {
        commonFrequency[i] = Math.min(commonFrequency[i], wordFreq[i]);
      }
    }
    List<String> result = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      int count = commonFrequency[i];
      while (count-- > 0) {
        result.add(String.valueOf((char) (97 + i)));
      }
    }
    return result;
  }
}
