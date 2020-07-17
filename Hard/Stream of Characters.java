class StreamChecker {
  TrieNode root;
  Deque<Character> stream;
  public StreamChecker(String[] words) {
    root = new TrieNode('-');
    stream = new ArrayDeque();
    for (String word : words) {
      addWord(word);
    }
  }
  
  private void addWord(String s) {
    TrieNode curr = root;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (!curr.map.containsKey(s.charAt(i))) {
        curr.map.put(s.charAt(i), new TrieNode(s.charAt(i)));
      }
      curr = curr.map.get(s.charAt(i));
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
      if (!curr.map.containsKey(c)) {
        return false;
      }
      curr = curr.map.get(c);
    }
    return curr.isWord;
  }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

class TrieNode {
  char c;
  Map<Character, TrieNode> map;
  boolean isWord;
  
  public TrieNode(char c) {
    this.c = c;
    map = new HashMap<>();
    isWord = false;
  }
}
