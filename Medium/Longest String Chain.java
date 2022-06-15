class Solution {
  public int longestStrChain(String[] words) {
    Map<String, Integer> dp = new HashMap<>();
    Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());
    int maxLength = 0;
    for (String word : words) {
      maxLength = Math.max(maxLength, dfs(wordSet, dp, word));
    }
    return maxLength;
  }
  
  private int dfs(Set<String> wordSet, Map<String, Integer> dp, String currWord) {
    if (dp.containsKey(currWord)) {
      return dp.get(currWord);
    }
    int maxLength = 1;
    StringBuilder sb = new StringBuilder(currWord);
    for (int i = 0; i < currWord.length(); i++) {
      sb.deleteCharAt(i);
      String newWord = sb.toString();
      if (wordSet.contains(newWord)) {
        maxLength = Math.max(maxLength, 1 + dfs(wordSet, dp, newWord));
      }
      sb.insert(i, currWord.charAt(i));
    }
    dp.put(currWord, maxLength);
    return dp.get(currWord);
  }
}
