class Solution {
  public List<String> printVertically(String s) {
    String[] words = s.split("\\s+");
    int longestWordLength = 0;
    for (String word : words) {
      longestWordLength = Math.max(longestWordLength, word.length());
    }
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < longestWordLength; i++) {
      StringBuilder sb = new StringBuilder();
      for (String word : words) {
        sb.append(i < word.length() ? word.charAt(i) : " ");
      }
      while (sb.charAt(sb.length() - 1) == ' ') {
        sb.deleteCharAt(sb.length() - 1);
      }
      if (sb.length() > 0) {
        ans.add(sb.toString());
      }
    }
    return ans;
  }
}
