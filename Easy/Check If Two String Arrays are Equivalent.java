class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idxOne = 0;
        int idxTwo = 0;
        int wordIdxOne = 0;
        int wordIdxTwo = 0;
        while (idxOne < word1.length && idxTwo < word2.length) {
            if (word1[idxOne].charAt(wordIdxOne) != word2[idxTwo].charAt(wordIdxTwo)) {
                return false;
            }
            wordIdxOne++;
            wordIdxTwo++;
            if (wordIdxOne == word1[idxOne].length()) {
                wordIdxOne = 0;
                idxOne++;
            }
            if (wordIdxTwo == word2[idxTwo].length()) {
                wordIdxTwo = 0;
                idxTwo++;
            }
        }
        return idxOne == word1.length && idxTwo == word2.length;
    }
}
