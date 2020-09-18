class WordFilter {

  Node root;
  Map<String, Integer> weightMap;
  public WordFilter(String[] words) {
    root = new Node('-');
    weightMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      root.words.add(words[i]);
      addWord(words[i], 0, root);
      weightMap.put(words[i], i);
    }
  }
  
  private void addWord(String word, int idx, Node curr) {
    if (idx == word.length()) {
      return;
    }
    char c = word.charAt(idx);
    if (!curr.children.containsKey(c)) {
      curr.children.put(c, new Node(c));
    }
    curr = curr.children.get(c);
    curr.words.add(word);
    addWord(word, idx + 1, curr);
  }

  public int f(String prefix, String suffix) {
    Node curr = root;
    if (prefix.length() != 0) {
      for (char c : prefix.toCharArray()) {
        if (!curr.children.containsKey(c)) {
          return -1;
        }
        curr = curr.children.get(c);
      }
    }
    int ans = -1;
    for (String word : curr.words) {
      if (suffix.length() == 0 || word.endsWith(suffix)) {
        ans = Math.max(ans, weightMap.get(word));
      }
    }
    return ans;
  }
}


class Node {
  char c;
  Map<Character, Node> children;
  Set<String> words;
  
  public Node(char c) {
    this.c = c;
    children = new HashMap<>();
    words = new HashSet<>();
  } 
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
