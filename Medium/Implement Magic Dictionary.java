class MagicDictionary {

  /** Initialize your data structure here. */
  Set<String> words;
  Map<String, Integer> count;
  public MagicDictionary() {
    words = new HashSet<>();
    count = new HashMap<>();
  }
  
  private List<String> generalizedNeighbour(String word) {
    List<String> list = new ArrayList<>();
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char letter = chars[i];
      chars[i] = '*';
      String magic = new String(chars);
      list.add(magic);
      chars[i] = letter;
    }
    return list;
  }

  /** Build a dictionary through a list of words */
  public void buildDict(String[] dict) {
    for (String word : dict) {
      words.add(word);
      for (String neighbour : generalizedNeighbour(word)) {
        count.put(neighbour, count.getOrDefault(neighbour, 0) + 1);
      }
    }
  }

  /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
  public boolean search(String word) {
    for (String neighbour : generalizedNeighbour(word)) {
      int c = count.getOrDefault(neighbour, 0);
      if (c > 1 || c == 1 && !words.contains(word)) {
        return true;
      }
    }
    return false;
  }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
