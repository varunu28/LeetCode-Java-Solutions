class Solution {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    int wordIdxOne = 0;
    int wordIdxTwo = 0;
    int idxOne = 0;
    int idxTwo = 0;
    while (wordIdxOne < word1.length && wordIdxTwo < word2.length) {
      if (idxOne == word1[wordIdxOne].length() || idxTwo == word2[wordIdxTwo].length()) {
        if (idxOne == word1[wordIdxOne].length()) {
          wordIdxOne++;
          idxOne = 0;
        }
        if (idxTwo == word2[wordIdxTwo].length()) {
          wordIdxTwo++;
          idxTwo = 0;
        }
      } else {
        if (word1[wordIdxOne].charAt(idxOne) != word2[wordIdxTwo].charAt(idxTwo)) {
          return false;
        }
        idxOne++;
        idxTwo++;
      }
    }
    return wordIdxOne == word1.length && wordIdxTwo == word2.length;
  }
}
