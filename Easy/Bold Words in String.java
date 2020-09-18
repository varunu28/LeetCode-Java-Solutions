class Solution {
  public String boldWords(String[] words, String S) {
    int N = S.length();
    boolean[] mask = new boolean[N];
    for (int i = 0; i < N; ++i) {
      for (String word: words) search: {
        for (int k = 0; k < word.length(); ++k) {
          if (k + i >= S.length() || S.charAt(k + i) != word.charAt(k)) {
            break search;
          }
        }
        for (int j = i; j < i + word.length(); ++j) {
          mask[j] = true;
        }
      }
    }
    StringBuilder ans = new StringBuilder();
    int anchor = 0;
    for (int i = 0; i < N; ++i) {
      if (mask[i] && (i == 0 || !mask[i - 1])) {
        ans.append("<b>");
      }
      ans.append(S.charAt(i));
      if (mask[i] && (i == N - 1 || !mask[i + 1])) {
        ans.append("</b>");
      }
    }
    return ans.toString();
  }
}
