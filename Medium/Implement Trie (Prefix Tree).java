class Trie {

  /** Initialize your data structure here. */
  Node root;
  public Trie() {
    root = new Node('-');
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    insertHelper(word, 0, root);
  }
  
  private void insertHelper(String word, int idx, Node root) {
    if (idx >= word.length()) {
      root.isWord = true;
      return;
    }
    if (!root.children.containsKey(word.charAt(idx))) {
      root.children.put(word.charAt(idx), new Node(word.charAt(idx)));
    }
    root = root.children.get(word.charAt(idx));
    insertHelper(word, idx + 1, root);
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    return searchHelper(word, 0, root);
  }
  
  private boolean searchHelper(String word, int idx, Node root) {
    if (idx == word.length()) {
      return root.isWord;
    }
    if (!root.children.containsKey(word.charAt(idx))) {
      return false;
    }
    root = root.children.get(word.charAt(idx));
    return searchHelper(word, idx + 1, root);
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return startsWithHelper(prefix, 0, root);
  }
  
  private boolean startsWithHelper(String word, int idx, Node root) {
    if (idx == word.length()) {
      return true;
    }
    if (!root.children.containsKey(word.charAt(idx))) {
      return false;
    }
    root = root.children.get(word.charAt(idx));
    return startsWithHelper(word, idx + 1, root);
  }
}

class Node {
  char val;
  Map<Character, Node> children;
  boolean isWord;
  
  public Node(char val) {
    this.val = val;
    children = new HashMap<>();
    isWord = false;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
