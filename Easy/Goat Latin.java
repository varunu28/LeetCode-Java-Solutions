class Solution {
  public String toGoatLatin(String S) {
    StringBuilder sb = new StringBuilder();
    StringBuilder endAppend = new StringBuilder("a");
    final String CONSTANT_APPEND = "ma";
    int start = 0;
    int end = 0;
    int n = S.length();
    while (end < n) {
      while (end < n && S.charAt(end) != ' ') {
        end++;
      }
      char c = Character.toLowerCase(S.charAt(start));
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        sb.append(S.substring(start, end)).append(CONSTANT_APPEND).append(endAppend.toString());
      }
      else {
        sb.append(S.substring(start + 1, end)).append(S.charAt(start)).append(CONSTANT_APPEND).append(endAppend.toString());
      }
      endAppend.append('a');
      end++;
      start = end;
      if (end < n) {
        sb.append(' ');
      }
    }
    return sb.toString();
  }
}
