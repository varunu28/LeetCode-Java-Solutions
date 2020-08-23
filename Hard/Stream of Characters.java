class StreamChecker {
  TrieNode root;
  Deque<Character> stream;
  public StreamChecker(String[] words) {
    root = new TrieNode('-');
    stream = new ArrayDeque();
    for (String word : words) {
      TrieNode curr = root;
      for (int i = word.length() - 1; i >= 0; i--) {
        if (!curr.map.containsKey(word.charAt(i))) {
          curr.map.put(word.charAt(i), new TrieNode(word.charAt(i)));
        }
        curr = curr.map.get(word.charAt(i));
      }
      curr.isWord = true;
    }
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

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
