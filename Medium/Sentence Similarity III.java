class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int idxOneStart = 0;
        int idxTwoStart = 0;
        String[] wordsOne = sentence1.split("\\s+"); 
        String[] wordsTwo = sentence2.split("\\s+"); 
        while (idxOneStart < wordsOne.length && idxOneStart < wordsTwo.length && wordsOne[idxOneStart].equals(wordsTwo[idxTwoStart])) {
            idxOneStart++;
            idxTwoStart++;
        }
        boolean startFound = idxOneStart > 0;
        if (idxOneStart == wordsOne.length && idxTwoStart == wordsTwo.length) {
            return true;
        }
        int idxOneEnd = wordsOne.length - 1;
        int idxTwoEnd = wordsTwo.length - 1;
        while (idxOneEnd >= idxOneStart && idxTwoEnd >= idxTwoStart && wordsOne[idxOneEnd].equals(wordsTwo[idxTwoEnd])) {
            idxOneEnd--;
            idxTwoEnd--;
        }
        if (idxOneEnd != idxOneStart - 1 && idxTwoEnd != idxTwoStart - 1) {
            return false;
        }
        return true;
    }
}
