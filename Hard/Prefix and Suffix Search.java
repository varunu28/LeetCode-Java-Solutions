class WordFilter {

  private TrieNode root;
  
  public WordFilter(String[] words) {
    this.root = new TrieNode();
    for (int i = 0; i < words.length; i++) {
      indexWord(words[i], i);
    }
  }

  public int f(String prefix, String suffix) {
    TrieNode curr = root;
    for (char c : (suffix + "{" + prefix).toCharArray()) {
      if (curr.children[c - 'a'] == null) {
        return -1;
      }
      curr = curr.children[c - 'a'];
    }
    return curr.maxIdx;
  }

  private void indexWord(String word, int idx) {
    for (int i = word.length() - 1; i >= 0; i--) {
      String suffixAndPrefix = word.substring(i, word.length()) + "{" + word;
      TrieNode curr = root;
      for (char c : suffixAndPrefix.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new TrieNode();
        }
        curr = curr.children[c - 'a'];
        curr.maxIdx = idx;
      }
    }
  }
  
  
  private class TrieNode {
    TrieNode[] children;
    int maxIdx;    
    public TrieNode() {
      this.children = new TrieNode[27];
      this.maxIdx = 0;
    }
  }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
