class Solution {
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    TrieNode root = new TrieNode('-');
    for (String word : words) {
      addWord(word, root);
    }
    List<String> concatenations = new ArrayList<>();
    for (String word : words) {
      if (isConcatentation(word, root, 0, 0)) {
        concatenations.add(word);
      }
    }
    return concatenations;
  }
  
  private void addWord(String s, TrieNode root) {
    TrieNode curr = root;
    for (int i = 0; i < s.length(); i++) {
      if (!curr.map.containsKey(s.charAt(i))) {
        curr.map.put(s.charAt(i), new TrieNode(s.charAt(i)));
      }
      curr = curr.map.get(s.charAt(i));
    }
    curr.isWord = true;
  }
  
  private boolean isConcatentation(String s, TrieNode root, int idx, int count) {
    TrieNode curr = root;
    for (int i = idx; i < s.length(); i++) {
      if (!curr.map.containsKey(s.charAt(i))) {
        return false;
      }
      if (curr.map.get(s.charAt(i)).isWord) {
        if (i == s.length() - 1) {
          return count >= 1;
        }
        if (isConcatentation(s, root, i + 1, count + 1)) {
          return true;
        }
      }
      curr = curr.map.get(s.charAt(i));
    }
    return false;
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
