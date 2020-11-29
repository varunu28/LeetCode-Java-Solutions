class Solution {
  public int maxRepeating(String sequence, String word) {
    int maxCount = 0;
    int idx = 0;
    int wordLength = word.length();
    int limitLength = sequence.length() - wordLength + 1;
    while (idx < limitLength) {
      int currCount = 0;
      while (idx < limitLength && sequence.substring(idx, idx + wordLength).equals(word)) {
        currCount++;
        idx += wordLength;
      }
      maxCount = Math.max(maxCount, currCount);
      idx++;
    }
    return maxCount;
  } 
}
