class Solution {
  public String boldWords(String[] words, String s) {
    List<int[]> indexes = new ArrayList<>();
    for (String word : words) {
      indexes.addAll(getIndexPair(s, word));
    }
    Collections.sort(indexes,
        Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
    Set<Integer> startIdx = new HashSet<>();
    Set<Integer> endIdx = new HashSet<>();
    int idx = 0;
    while (idx < indexes.size()) {
      int currStart = indexes.get(idx)[0];
      int currEnd = indexes.get(idx)[1];
      idx++;
      while (idx < indexes.size() && indexes.get(idx)[0] <= currEnd + 1) {
        currEnd = Math.max(currEnd, indexes.get(idx++)[1]);
      }
      startIdx.add(currStart);
      endIdx.add(currEnd);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (startIdx.contains(i)) {
        sb.append("<b>");
      }
      sb.append(s.charAt(i));
      if (endIdx.contains(i)) {
        sb.append("</b>");
      }
    }
    return sb.toString();
  }
  
  private List<int[]> getIndexPair(String s, String word) {
    List<int[]> indexPairs = new ArrayList<>();
    for (int i = 0; i < s.length() - word.length() + 1; i++) {
      if (s.startsWith(word, i)) {
        indexPairs.add(new int[]{i, i + word.length() - 1});
      }
    }
    return indexPairs;
  }
}
