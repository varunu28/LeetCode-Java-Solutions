class Trie {
  
  private TrieNode root;
  
  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode curr = root;
    for (char c : word.toCharArray()) {
      if (!curr.children.containsKey(c)) {
        curr.children.put(c, new TrieNode());
      }
      curr = curr.children.get(c);
    }
    curr.isWord = true;
  }

  public boolean search(String word) {
    TrieNode searchNode = searchHelper(word);
    return searchNode != null && searchNode.isWord;
  }

  public boolean startsWith(String prefix) {
    return searchHelper(prefix) != null;
  }
  
  private TrieNode searchHelper(String s) {
    TrieNode curr = root;
    for (char c : s.toCharArray()) {
      if (!curr.children.containsKey(c)) {
        return null;
      }
      curr = curr.children.get(c);
    }
    return curr;
  }
  
  private class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    
    public TrieNode() {
      this.children = new HashMap<>();
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
