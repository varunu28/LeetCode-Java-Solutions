class AutocompleteSystem {
  Map<String, Integer> map;
  Node root;
  Node currNode;
  StringBuilder sb;
  boolean invalidQuery;
  public AutocompleteSystem(String[] sentences, int[] times) {
    map = new HashMap<>();
    root = new Node('-');
    for (int i = 0; i < sentences.length; i++) {
      addSentence(sentences[i], 0, root);
      map.put(sentences[i], map.getOrDefault(sentences[i], 0) + times[i]);
    }
    currNode = root;
    invalidQuery = false;
    sb = new StringBuilder();
  }
  
  private void addSentence(String s, int idx, Node root) {
    if (idx == s.length()) {
      return;
    }
    char c = s.charAt(idx);
    if (!root.children.containsKey(c)) {
      root.children.put(c, new Node(c));
    }
    Node node = root.children.get(c);
    node.possibleSentences.add(s);
    addSentence(s, idx + 1, node);
  }

  public List<String> input(char c) {
    if (c == '#') {
      String s = sb.toString();
      map.put(s, map.getOrDefault(s, 0) + 1);
      addSentence(s, 0, root);
      sb.setLength(0);
      currNode = root;
      invalidQuery = false;
      return new ArrayList<>();
    }
    sb.append(c);
    if (!currNode.children.containsKey(c) || invalidQuery) {
      invalidQuery = true;
      return new ArrayList<>();
    }
    else {
      List<String> possibleSentences = new ArrayList<>();
      currNode = currNode.children.get(c);
      possibleSentences.addAll(currNode.possibleSentences);
      return getTopThree(possibleSentences);
    }
  }
  
  private List<String> getTopThree(List<String> list) {
    Collections.sort(list, new Comparator<String>(){
      public int compare(String s1, String s2) {
        int c = map.get(s2) - map.get(s1);
        if (c != 0) {
          return c;
        }
        return s1.compareTo(s2);
      }
    });
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < list.size() && ans.size() < 3; i++) {
      ans.add(list.get(i));
    }
    return ans;
  }
}

class Node {
  char c;
  Map<Character, Node> children;
  Set<String> possibleSentences;
  
  public Node(char c) {
    this.c = c;
    children = new HashMap<>();
    possibleSentences = new HashSet<>();
  }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
