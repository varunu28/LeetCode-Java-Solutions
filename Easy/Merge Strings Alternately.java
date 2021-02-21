class Solution {
  public String mergeAlternately(String word1, String word2) {
    int idx1 = 0;
    int idx2 = 0;
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    while (idx1 < word1.length() && idx2 < word2.length()) {
      sb.append(first ? word1.charAt(idx1++) : word2.charAt(idx2++));
      first = !first;
    }
    while (idx1 < word1.length()) {
      sb.append(word1.charAt(idx1++));
    }
    while (idx2 < word2.length()) {
      sb.append(word2.charAt(idx2++));
    }
    return sb.toString();
  }
}
