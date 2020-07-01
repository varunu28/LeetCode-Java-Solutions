class Solution {
  public List<String> removeComments(String[] source) {
    StringBuilder sb = new StringBuilder();
    List<String> list = new ArrayList<>();
    boolean blockComment = false;
    for (String word : source) {
      for (int i = 0; i < word.length(); i++) {
        if (!blockComment) {
          if ((i + 1) < word.length() && word.charAt(i) == '/' && word.charAt(i + 1) == '/') {
            break;
          }
          else if ((i + 1) < word.length() && word.charAt(i) == '/' && word.charAt(i + 1) == '*') {
            blockComment = true;
            i++;
          }
          else {
            sb.append(word.charAt(i));
          }
        }
        else {
          if ((i + 1) < word.length() && word.charAt(i) == '*' && word.charAt(i + 1) == '/') {
            blockComment = false;
            i++;
          }
        }
      }
      if (!blockComment && sb.length() > 0) {
        list.add(sb.toString());
        sb.setLength(0);
      }
    }
    return list;
  }
}
