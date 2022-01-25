class Solution {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int idxOne = -1;
    int idxTwo = -1;
    int minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        idxOne = i;
      } else if (wordsDict[i].equals(word2)) {
        idxTwo = i;
      }
      if (idxOne != -1 && idxTwo != -1) {
        minDistance = Math.min(minDistance, Math.abs(idxOne - idxTwo));
      }
    }
    return minDistance;
  }
}
