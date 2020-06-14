class Solution {
  public String replaceWords(List<String> dict, String sentence) {
    Node root = new Node('-');
    for (String word : dict) {
      addWord(word, 0, root);
    }
    String[] words = sentence.split("\\s+");
    for (int i = 0; i < words.length; i++) {
      String prefix = getPrefix(words[i], root);
      if (prefix != null) {
        words[i] = prefix;
      }
    }
    return String.join(" ", words);
  }
  
  private String getPrefix(String word, Node root) {
    for (int i = 0; i < word.length(); i++) {
      if (!root.children.containsKey(word.charAt(i))) {
        return null;
      }
      root = root.children.get(word.charAt(i));
      if (root.word != null) {
        return root.word;
      }
    }
    return null;
  }
  
  private void addWord(String word, int idx, Node root) {
    if (idx == word.length()) {
      return;
    }
    if (!root.children.containsKey(word.charAt(idx))) {
      root.children.put(word.charAt(idx), new Node(word.charAt(idx)));
    }
    root = root.children.get(word.charAt(idx));
    if (idx == word.length() - 1) {
      root.word = word;
    }
    addWord(word, idx + 1, root);
  }
}


class Node {
  char c;
  Map<Character, Node> children;
  String word;
  
  public Node(char c) {
    this.c = c;
    children = new HashMap<>();
    word = null;
  }
}
