class MapSum {

  /** Initialize your data structure here. */
  TrieNode root;
  Map<String, Integer> map;
  public MapSum() {
    root = new TrieNode('-');
    map = new HashMap<>();
  }

  public void insert(String key, int val) {
    int delta = val - map.getOrDefault(key, 0);
    map.put(key, val);
    TrieNode curr = root;
    for (int i = 0; i < key.length(); i++) {
      if (!curr.map.containsKey(key.charAt(i))) {
        curr.map.put(key.charAt(i), new TrieNode(key.charAt(i)));
      }
      curr = curr.map.get(key.charAt(i));
      curr.score += delta;
    }
  }

  public int sum(String prefix) {
    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      if (!curr.map.containsKey(prefix.charAt(i))) {
        return 0;
      }
      curr = curr.map.get(prefix.charAt(i));
    }
    return curr.score;
  }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

class TrieNode {
  char c;
  Map<Character, TrieNode> map;
  int score;
  
  public TrieNode(char c) {
    this.c = c;
    map = new HashMap<>();
    score = 0;
  }
}
