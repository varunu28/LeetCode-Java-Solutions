class WordDistance {
  Map<String, List<Integer>> map;
  public WordDistance(String[] words) {
    map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> idxList1 = map.get(word1);
    List<Integer> idxList2 = map.get(word2);
    int idx1 = 0;
    int idx2 = 0;
    int minDiff = Math.abs(idxList1.get(idx1) - idxList2.get(idx2));
    while (idx1 < idxList1.size() && idx2 < idxList2.size()) {
      minDiff = Math.min(minDiff, Math.abs(idxList1.get(idx1) - idxList2.get(idx2)));
      if (idxList1.get(idx1) < idxList2.get(idx2)) {
        idx1++;
      }
      else {
        idx2++;
      }
    }
    return minDiff;
  }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
