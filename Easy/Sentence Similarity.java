class Solution {
  public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
    if (words1.length != words2.length) {
      return false;
    }
    Set<String> set = new HashSet<>();
    for (List<String> pair : pairs) {
      String word1 = pair.get(0);
      String word2 = pair.get(1);
      set.add(word1 + "|" + word2);
    }
    for (int i = 0; i < words1.length; i++) {
      String word1 = words1[i];
      String word2 = words2[i];
      if (!(word1.equals(word2) || set.contains(word1 + "|" + word2) || set.contains(word2 + "|" + word1))) {
        return false;
      }
    }
    return true;
  }
}
