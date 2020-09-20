class Solution {
  public String reorderSpaces(String text) {
    int totalSpaces = 0;
    StringBuilder sb = new StringBuilder();
    List<String> words = new ArrayList<>();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == ' ') {
        totalSpaces++;
        if (sb.length() > 0) {
          words.add(sb.toString());
          sb.setLength(0);
        }
      }
      else {
        sb.append(c);
      }
      if (i == text.length() - 1 && sb.length() > 0) {
        words.add(sb.toString());
        sb.setLength(0);
      }
    }
    int batchSize = totalSpaces / (words.size() > 1 ? (words.size() - 1) : 1);
    int remainingSpace = words.size() > 1 ? totalSpaces % (words.size() - 1)  : totalSpaces;
    String space = String.join("", Collections.nCopies(batchSize, " "));
    sb.append(words.get(0));
    for (int i = 1; i < words.size(); i++) {
      sb.append(space.toString());
      sb.append(words.get(i));
    }
    sb.append(String.join("", Collections.nCopies(remainingSpace, " ")));
    return sb.toString();
  }
}
