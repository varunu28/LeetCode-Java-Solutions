class Solution {
  Map<Integer, List<String>> map;
  int maxVal;
  public String longestWord(String[] words) {
    map = new HashMap<>();
    maxVal = Integer.MIN_VALUE;
    Node root = new Node('-');
    Arrays.sort(words);
    for (String word : words) {
      addWord(word, root, 0);
    }
    if (maxVal == Integer.MIN_VALUE) {
      return "";
    }
    List<String> possibleAns = map.get(maxVal);
    Collections.sort(possibleAns);
    return possibleAns.get(0);
  }
  
  private void addWord(String word, Node root, int idx) {
    char c = word.charAt(idx);
    if (!root.children.containsKey(c) && idx != word.length() - 1) {
      return;
    }
    if (!root.children.containsKey(c)) {
      root.children.put(c, new Node(c));
    }
    root = root.children.get(c);
    if (idx == word.length() - 1) {
      root.isWord = true;
      int wordLength = word.length();
      map.computeIfAbsent(wordLength, k -> new ArrayList<>()).add(word);
      maxVal = Math.max(maxVal, wordLength);
    }
    else {
      addWord(word, root, idx + 1);
    }
  }
}

class Node {
  char val;
  boolean isWord;
  Map<Character, Node> children;
  
  public Node(char val) {
    this.val = val;
    isWord = true;
    children = new HashMap<>();
  }
}
