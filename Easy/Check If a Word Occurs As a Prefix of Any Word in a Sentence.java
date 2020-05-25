class Solution {
  public int isPrefixOfWord(String sentence, String searchWord) {
    Node root = new Node('-');
    String[] words = sentence.split("\\s+");
    Map<String, Integer> indexMap = new HashMap<>();
    for (int i = 0; i< words.length; i++) {
      addWord(words[i], root, 0);
      if (!indexMap.containsKey(words[i])) {
        indexMap.put(words[i], i + 1);
      }
    }
    for (int i = 0; i < searchWord.length(); i++) {
      char c = searchWord.charAt(i);
      if (!root.map.containsKey(c)) {
        return -1;
      }
      root = root.map.get(c);
    }
    PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
      public int compare(String s1, String s2) {
        return indexMap.get(s1) - indexMap.get(s2);
      }
    });
    pq.addAll(root.words);
    return indexMap.get(pq.poll());
  }
  
  private void addWord(String s, Node root, int idx) {
    if (idx == s.length()) {
      return;
    }
    char c = s.charAt(idx);
    if (!root.map.containsKey(c)) {
      root.map.put(c, new Node(c));
    }
    Node next = root.map.get(c);
    next.words.add(s);
    addWord(s, next, idx + 1);
  }
}

class Node {
  char c;
  Map<Character, Node> map;
  Set<String> words;
  
  public Node(char c) {
    this.c = c;
    map = new HashMap<>();
    words = new HashSet<>();
  }
}
