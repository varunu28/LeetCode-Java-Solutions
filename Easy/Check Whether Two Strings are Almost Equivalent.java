class Solution {
  public boolean checkAlmostEquivalent(String word1, String word2) {
    int[] counter = new int[26];
    for (int i = 0; i < word1.length(); i++) {
      counter[word1.charAt(i) - 'a']++;
      counter[word2.charAt(i) - 'a']--;
    }
    return IntStream.range(0, 26).allMatch(idx -> Math.abs(counter[idx]) <= 3);
  }
}
