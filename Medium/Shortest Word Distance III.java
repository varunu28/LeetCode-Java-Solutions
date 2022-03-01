class Solution {
  public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
    int minIdxDiff = wordsDict.length;
    int prevIdx = -1;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
        if (prevIdx != -1 && (word1.equals(word2) || !wordsDict[prevIdx].equals(wordsDict[i]))) {
          minIdxDiff = Math.min(minIdxDiff, Math.abs(prevIdx - i));
        }
        prevIdx = i;
      }
    }
    return minIdxDiff;
  }
}
