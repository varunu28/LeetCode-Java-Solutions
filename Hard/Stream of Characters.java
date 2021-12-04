class StreamChecker {
  
  Deque<Character> stream;
  TrieNode root;
  public StreamChecker(String[] words) {
    root = new TrieNode('-');
    stream = new ArrayDeque<>();
    Arrays.stream(words).forEach(word -> addWord(word));
  }
  
  public void addWord(String word) {
    TrieNode curr = root;
    for (int i = word.length() - 1; i >= 0; i--) {
      char c = word.charAt(i);
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new TrieNode(c);
      }
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }

  public boolean query(char letter) {
    stream.addFirst(letter);
    TrieNode curr = root;
    for (char c : stream) {
      if (curr.isWord) {
        return true;
      }
      if (curr.children[c - 'a'] == null) {
        return false;
      }
      curr = curr.children[c - 'a'];
    }
    return curr.isWord;
  }
  
  
  class TrieNode {
    char c;
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode(char c) {
      this.c = c;
      children = new TrieNode[26];
    }
  }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
