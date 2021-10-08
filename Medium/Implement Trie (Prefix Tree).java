class Trie {

  TrieNode root;
  public Trie() {
    root = new TrieNode('-');
  }

  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      if (node.children[word.charAt(i) - 'a'] == null) {
        node.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
      }
      node = node.children[word.charAt(i) - 'a'];
      if (i == word.length() - 1) {
        node.isWord = true;
      }
    }
  }

  public boolean search(String word) {
    TrieNode node = searchHelper(word);
    return node != null && node.isWord;
  }

  public boolean startsWith(String prefix) {
    return searchHelper(prefix) != null;
  }
  
  private TrieNode searchHelper(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      if (node.children[word.charAt(i) - 'a'] == null) {
        return null;
      }
      node = node.children[word.charAt(i) - 'a'];
    }
    return node;
  }
  
  class TrieNode {
    TrieNode[] children;
    boolean isWord;
    char c;
    
    public TrieNode(char c) {
      this.c = c;
      children = new TrieNode[26];
      isWord = false;
    }
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
