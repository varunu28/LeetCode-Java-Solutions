class Solution {
  public List<Integer> partitionLabels(String s) {
    Map<Character, Integer> lastIndex = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      lastIndex.put(s.charAt(i), i);
    }
    List<Integer> partitionIndices = new ArrayList<>();
    int currMaxIdx = -1;
    int prevIdx = 0;
    for (int i = 0; i < s.length(); i++) {
      currMaxIdx = Math.max(currMaxIdx, lastIndex.get(s.charAt(i)));
      if (i == currMaxIdx) {
        partitionIndices.add(i - prevIdx + 1);
        prevIdx = i + 1;
      }
    }
    return partitionIndices;
  }
}
