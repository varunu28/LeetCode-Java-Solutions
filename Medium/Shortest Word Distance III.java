class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int idxOne = -1;
        int idxTwo = -1;
        int minDistance = Integer.MAX_VALUE;
        boolean sameWord = word1.equals(word2);
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                idxOne = sameWord ? (idxOne == -1 ? i : idxOne) : i; 
            }
            if (wordsDict[i].equals(word2)) {
                idxTwo = sameWord ? (idxOne != i ? i : idxTwo) : i; 
            }
            if (idxOne != -1 && idxTwo != -1) {
                minDistance = Math.min(minDistance, Math.abs(idxOne - idxTwo));
                if (sameWord) {
                    idxOne = idxTwo;
                    idxTwo = -1;
                }
            }
        }
        return minDistance;
    }
}
