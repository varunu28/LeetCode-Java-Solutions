class Trie {

  private Node head;

  public Trie() {
    this.head = new Node('-');
  }

  public void insert(String word) {
    Node curr = this.head;
    for (char c : word.toCharArray()) {
      if (!curr.children.containsKey(c)) {
        curr.children.put(c, new Node(c));
      }
      curr = curr.children.get(c);
    }
    curr.wordToFrequency.put(word, curr.wordToFrequency.getOrDefault(word, 0) + 1);
  }

  public int countWordsEqualTo(String word) {
    Node curr = this.head;
    curr = traverseTrie(curr, word);
    if (curr == null) {
      return 0;
    }
    return curr.wordToFrequency.getOrDefault(word, 0);
  }

  public int countWordsStartingWith(String prefix) {
    Node curr = this.head;
    curr = traverseTrie(curr, prefix);
    if (curr == null) {
      return 0;
    }
    int count = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.add(curr);
    while (!queue.isEmpty()) {
      Node removed = queue.remove();
      for (String word : removed.wordToFrequency.keySet()) {
        count += removed.wordToFrequency.get(word);
      }
      for (Character child : removed.children.keySet()) {
        queue.add(removed.children.get(child));
      }
    }
    return count;
  }

  public void erase(String word) {
    Node curr = this.head;
    curr = traverseTrie(curr, word);
    if (curr == null || curr.wordToFrequency.getOrDefault(word, 0) == 0) {
      return;
    }
    curr.wordToFrequency.put(word, curr.wordToFrequency.get(word) - 1);
  }

  private Node traverseTrie(Node curr, String word) {
    for (char c : word.toCharArray()) {
      if (!curr.children.containsKey(c)) {
        return null;
      }
      curr = curr.children.get(c);
    }
    return curr;
  }

  private static class Node {
    char c;
    Map<Character, Node> children;
    Map<String, Integer> wordToFrequency;

    public Node(char c) {
      this.c = c;
      this.children = new HashMap<>();
      this.wordToFrequency = new HashMap<>();
    }
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
