class WordDistance {
  
  private Map<String, List<Integer>> locations;

  public WordDistance(String[] wordsDict) {
    this.locations = new HashMap<>();
    for (int i = 0; i < wordsDict.length; i++) {
      this.locations.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> indicesOne = this.locations.get(word1);
    List<Integer> indicesTwo = this.locations.get(word2);
    int idxOne = 0;
    int idxTwo = 0;
    int minimumIndexDifference = Integer.MAX_VALUE;
    while (idxOne < indicesOne.size() && idxTwo < indicesTwo.size()) {
      minimumIndexDifference = Math.min(
        minimumIndexDifference, 
        Math.abs(indicesOne.get(idxOne) - indicesTwo.get(idxTwo)));
      if (indicesOne.get(idxOne) < indicesTwo.get(idxTwo)) {
        idxOne++;
      } else {
        idxTwo++;
      }
    }
    return minimumIndexDifference;
  }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
