class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    int numberOfWords = words.length;
    int singleWordLength = words[0].length();
    int totalSubstringLength = singleWordLength * numberOfWords;
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < singleWordLength; i++) {
      slidingWindow(i, s, result, singleWordLength, totalSubstringLength, wordCount, numberOfWords);
    }
    return result;
  }

  private void slidingWindow(int left, String s, List<Integer> answer, int singleWordLength,
      int totalSubstringLength, Map<String, Integer> wordCount, int numberOfWords) {
    Map<String, Integer> wordsFound = new HashMap<>();
    int wordsUsed = 0;
    boolean excessWord = false;
    int n = s.length();
    for (int right = left; right <= n - singleWordLength; right += singleWordLength) {
      String currSubstring = s.substring(right, right + singleWordLength);
      if (!wordCount.containsKey(currSubstring)) {
        wordsFound.clear();
        wordsUsed = 0;
        excessWord = false;
        left = right + singleWordLength;
      } else {
        while (right - left == totalSubstringLength || excessWord) {
          String leftmostWord = s.substring(left, left + singleWordLength);
          left += singleWordLength;
          wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);
          if (wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord)) {
            excessWord = false;
          } else {
            wordsUsed--;
          }
        }
        wordsFound.put(currSubstring, wordsFound.getOrDefault(currSubstring, 0) + 1);
        if (wordsFound.get(currSubstring) <= wordCount.get(currSubstring)) {
          wordsUsed++;
        } else {
          excessWord = true;
        }
        if (wordsUsed == numberOfWords && !excessWord) {
          answer.add(left);
        }
      }
    }
  }
}
