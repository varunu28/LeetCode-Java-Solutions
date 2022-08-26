class WordDictionary {
  
  private Node root;
  
  public WordDictionary() {
    this.root = new Node();
  }

  public void addWord(String word) {
    Node curr = root;
    for (char c : word.toCharArray()) {
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new Node();
      }
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }

  public boolean search(String word) {
    Node curr = root;
    return searchHelper(word, 0, curr);
  }
  
  private boolean searchHelper(String word, int idx, Node curr) {
    if (idx == word.length()) {
      return curr.isWord;
    }
    if (word.charAt(idx) != '.' && curr.children[word.charAt(idx) - 'a'] == null) {
      return false;
    }
    if (word.charAt(idx) == '.') {
      for (Node child : curr.children) {
        if (child != null && searchHelper(word, idx + 1, child)) {
          return true;
        }
      }
      return false;
    }
    return searchHelper(word, idx + 1, curr.children[word.charAt(idx) - 'a']);
  }
  
  private static class Node {
    Node[] children;
    boolean isWord;
    
    public Node() {
      this.children = new Node[26];
      this.isWord = false;
    }
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
