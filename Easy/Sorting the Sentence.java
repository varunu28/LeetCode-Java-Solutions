class Solution {
  public String sortSentence(String s) {
    String[] arr = new String[s.split(" ").length];
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      int currIdx = idx;
      while (currIdx < n && Character.isLetter(s.charAt(currIdx))) {
        currIdx++;
      }
      int wordIdx = Character.getNumericValue(s.charAt(currIdx++));
      arr[wordIdx - 1] = s.substring(idx, currIdx - 1);
      idx = currIdx + 1;
    }
    StringBuilder sb = new StringBuilder();
    for (String word : arr) {
      sb.append(word).append(" ");
    }
    return sb.toString().trim();
  }
}
